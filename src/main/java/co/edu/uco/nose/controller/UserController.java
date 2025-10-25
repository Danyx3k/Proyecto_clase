package co.edu.uco.nose.controller;

import co.edu.uco.nose.controller.Dto.Response;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {

    @GetMapping
    public ResponseEntity<Response<UserDTO>> findAllUsers() {

        Response<UserDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try{

            var responseUserList = new ArrayList<UserDTO>();

            responseUserList.add(new UserDTO());
            responseUserList.add(new UserDTO());
            responseUserList.add(new UserDTO());
            responseUserList.add(new UserDTO());

            responseObjectData.addMessages("All user filtered succesfully");
            responseObjectData.setData(responseUserList);


        }catch (final NoseException exception){
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessages(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        }catch (final Exception exception){
            var userMassage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessages(userMassage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }
        return new ResponseEntity<>(responseObjectData,responseStatusCode);
    }

    @PostMapping
    public String registeNewUserInformation() {
        return "POST: USER Registered";
    }

    @PutMapping
    public String updateUserInformation() {
        return "UPDATE: User updated!";
    }

    @DeleteMapping
    public String dropUserInformation() {
        return "DELETE: User deleted!";
    }
}
