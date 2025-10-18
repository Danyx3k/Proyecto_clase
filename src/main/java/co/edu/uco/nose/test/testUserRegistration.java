package co.edu.uco.nose.test;

import co.edu.uco.nose.Business.business.fecade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;

public class testUserRegistration {

    public static void main(String[] args) {
        try {
            var user = new UserDTO();
            // Colocar todos los parámetros, menos el id

            var facade = new UserFacadeImpl();
            facade.resgitresNewUserInformation(user);

            System.out.println("Gané el semestre!!!");
        } catch (NoseException e) {
            System.out.println(e.getUserMessage());
            System.out.println(e.getTechnicalMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

