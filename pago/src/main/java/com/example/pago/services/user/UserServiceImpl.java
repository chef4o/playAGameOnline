package com.example.pago.services.user;

import com.example.pago.domains.dto.beans.LoggedUser;
import com.example.pago.domains.dto.bindings.UserLoginDto;
import com.example.pago.domains.dto.bindings.UserRegisterDto;
import com.example.pago.domains.dto.models.UserDto;
import com.example.pago.domains.dto.models.seed.UserSeedDto;
import com.example.pago.domains.dto.views.UserAdminViewDto;
import com.example.pago.domains.entities.User;
import com.example.pago.domains.enums.Gender;
import com.example.pago.domains.enums.Role;
import com.example.pago.repositories.UserRepository;
import com.example.pago.services.town.TownService;
import com.example.pago.utils.validation.ValidationUtil;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.pago.constant.filePaths.USERS_JSON_FILE;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final LoggedUser loggedUser;
    private final TownService townService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
                           ValidationUtil validationUtil, Gson gson, LoggedUser loggedUser, TownService townService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.loggedUser = loggedUser;
        this.townService = townService;
    }

    @Override
    public void dbImport() throws IOException {
        if (!dbExists()) {
            Arrays.stream(gson.fromJson(readFileContent(), UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userRepository -> modelMapper.map(userRepository, User.class))
                    .forEach(userRepository::saveAndFlush);
        }
    }

    @Override
    public boolean dbExists() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFileContent() throws IOException {
        return Files.readString(Path.of(USERS_JSON_FILE));
    }

    public List<String> getAllGenders() {
        return Arrays.stream(Gender.values())
                .map(gender ->
                        gender.name().substring(0, 1).toUpperCase()
                                + gender.name().substring(1).toLowerCase())
                .toList();
    }

    @Override
    public List<String> getRolesLowerThan(String roleName) {
        return Arrays.stream(Role.values())
                .filter(role -> role.ordinal() < Role.valueOf(roleName.toUpperCase()).ordinal())
                .map(role -> modelMapper.map(role, String.class))
                .toList();
    }

    @Override
    public UserDto registerUser(UserRegisterDto userRegisterDto) {
        final UserDto userDto = modelMapper.map(userRegisterDto, UserDto.class);
        userDto.setTown(townService.getTownByName(userRegisterDto.getTown()));

        if (!this.dbExists()) {
            userDto.setRole(Role.SUPER_ADMIN);
        } else if (userRegisterDto.hasAllOptional()) {
            userDto.setRole(Role.NORMAL);
        } else {
            userDto.setRole(Role.LIGHT);
        }

        if (userDto.getDateOfBirth() != null) {
            userDto.setAge(Math
                    .toIntExact(ChronoUnit.YEARS.between(userDto.getDateOfBirth(), LocalDate.now())));
        }

        final User userForInsert = this.modelMapper.map(userDto, User.class);
        UserDto registeredLoggedUser = this.modelMapper
                .map(this.userRepository.saveAndFlush(userForInsert), UserDto.class);

        this.loggedUser
                .setId(registeredLoggedUser.getId())
                .setEmail(registeredLoggedUser.getEmail())
                .setNickName(registeredLoggedUser.getNickName())
                .setFirstName(registeredLoggedUser.getFirstName())
                .setRole(registeredLoggedUser.getRole());

        return registeredLoggedUser;
    }

    @Override
    public UserDto loginUser(UserLoginDto userLoginDto) {
        Optional<User> current = userRepository.findByEmail(userLoginDto.getEmail());
        UserDto validatedUser = current.isPresent()
                && current.get().getPassword().equals(userLoginDto.getPassword())
                ? this.modelMapper.map(current.get(), UserDto.class)
                : new UserDto();

        if (validatedUser.exists()) {
            this.loggedUser
                    .setId(validatedUser.getId())
                    .setEmail(validatedUser.getEmail())
                    .setNickName(validatedUser.getNickName())
                    .setFirstName(validatedUser.getFirstName())
                    .setRole(validatedUser.getRole());
        }

        return validatedUser;
    }

    @Override
    public List<UserAdminViewDto> getUsersWithLowerRoleThan(String role) {
        return userRepository.findByRoleLowerThan(Role.valueOf(role.toUpperCase()).ordinal())
                .stream()
                .map(user -> modelMapper.map(user, UserAdminViewDto.class))
                .toList();
    }

    @Override
    public Integer getUserRole(Long userId) {
        return userRepository
                .findById(userId)
                .get()
                .getRole()
                .ordinal();
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        return this.userRepository
                .findById(id)
                .map(user -> modelMapper.map(user, UserDto.class));
    }

    @Override
    public UserAdminViewDto updateUser(Long id, UserAdminViewDto editedUser) {
        User userToUpdate = this.userRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
        if (!userToUpdate.getEmail().equals(editedUser.getEmail())) {
            userToUpdate.setEmail(editedUser.getEmail());
        }

        if (!userToUpdate.getNickName().equals(editedUser.getNickName())) {
            userToUpdate.setNickName(editedUser.getNickName());
        }

        Role role = modelMapper.map(editedUser.getRole(), Role.class);
        if (!userToUpdate.getRole().equals(role)) {
            userToUpdate.setRole(role);
        }

        this.userRepository.saveAndFlush(userToUpdate);

        return modelMapper.map(userToUpdate, UserAdminViewDto.class);
    }

    @Override
    public void logout(HttpSession session) {
        this.loggedUser.delete();
        session.invalidate();
    }
}
