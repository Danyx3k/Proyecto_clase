package co.edu.uco.nose.test;

import co.edu.uco.nose.Business.business.fecade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.helper.exception.NoseException;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.IdTypeDTO;
import co.edu.uco.nose.dto.UserDTO;

import java.util.UUID;

public class testUserRegistration {

    public static void main(String[] args) {
        try {
            var user = new UserDTO();
            var idType = new IdTypeDTO();
            idType.setId(UUID.fromString("463d0b30-4884-4761-9208-e65641c5401e"));
            idType.setName("Cédula de ciudadanía");
            user.setIdType(idType);

            // 🔹 Datos personales
            user.setIdNumber("1234567890");
            user.setFirstName("Dany");
            user.setSecondName("Andrés");
            user.setFirstSurname("Cardona");
            user.setSecondSurname("López");

            // 🔹 Ciudad
            var city = new CityDTO();
            city.setId(UUID.fromString("2ebd56ce-55e4-4c2a-a438-fbf43121efd8"));
            city.setName("Rionegro");
            user.setCity(city);

            // 🔹 Contacto
            user.seteMail("dany.cardona@example.com");
            user.setMobileNumber("3001234567");

            // 🔹 Confirmaciones
            user.seteMailConfirmed(false);
            user.setMobileNumberConfirmed(false);


            System.out.println("✅ ¡Gané el semestre!");

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
}
