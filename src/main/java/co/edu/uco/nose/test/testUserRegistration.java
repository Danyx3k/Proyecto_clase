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
            idType.setId(UUID.fromString("11111111-1111-1111-1111-111111111111"));
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
            city.setId(UUID.fromString("22222222-2222-2222-2222-222222222222"));
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
