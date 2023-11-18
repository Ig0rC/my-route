package br.dev.igorcardoso.myroute.useCases.user;

import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.useCases.user.DTOs.CreateUserDTO;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {

  @Autowired
  private CreateUserUseCase createUserUseCase;
  @Autowired
  private ListUserUseCase listUserUseCase;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody @Valid CreateUserDTO createUserDTO) throws Exception {
    this.createUserUseCase.execute(createUserDTO);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/")
  public ResponseEntity show() {
    List<User> users = this.listUserUseCase.execute();

    return ResponseEntity.ok().body(users);
  }
}
