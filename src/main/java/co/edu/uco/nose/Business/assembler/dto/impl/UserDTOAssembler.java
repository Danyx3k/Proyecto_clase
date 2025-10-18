package co.edu.uco.nose.Business.assembler.dto.impl;

package co.edu.uco.nose.Buisness.assembler.dto.impl;

import static co.edu.uco.nose.Business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;
import static co.edu.uco.nose.Business.assembler.dto.impl.IdTypeDTOAssembler.getIdTypeDTOAssembler;

import co.edu.uco.nose.Business.Domain.UserDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public final class UserDTOAssembler implements DTOassembler<UserDTO, UserDomain> {

    // ✅ Instancia única (Singleton)
    private static final DTOassembler<UserDTO, UserDomain> instance = new UserDTOAssembler();

    // 🚫 Constructor privado: evita crear instancias fuera de esta clase
    private UserDTOAssembler() { }

    // ✅ Método de acceso a la única instancia
    public static DTOassembler<UserDTO, UserDomain> getUserDTOAssembler() {
        return instance;
    }

    @Override
    public UserDTO toDTO(final UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));

        // Conversión de subdominios
        var idTypeDtoTmp = getIdTypeDTOAssembler().toDTO(domainTmp.getIdType());
        var cityDtoTmp = getCityDTOAssembler().toDTO(domainTmp.getCity());

        return new UserDTO(
                domainTmp.getId(),
                idTypeDtoTmp,
                domainTmp.getIdNumber(),
                domainTmp.getFirstName(),
                domainTmp.getSecondName(),
                domainTmp.getFirstSurname(),
                domainTmp.getSecondSurname(),
                cityDtoTmp,
                domainTmp.geteMail(),
                domainTmp.getMobileNumber(),
                domainTmp.iseMailConfirmed(),
                domainTmp.isMobileNumberConfirmed()
        );
    }

    @Override
    public UserDomain toDomain(final UserDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());

        // Conversión de subobjetos
        var idTypeDomainTmp = getIdTypeDTOAssembler().toDomain(dtoTmp.getIdType());
        var cityDomainTmp = getCityDTOAssembler().toDomain(dtoTmp.getCity());

        return new UserDomain(
                dtoTmp.getId(),
                idTypeDomainTmp,
                dtoTmp.getIdNumber(),
                dtoTmp.getFirstName(),
                dtoTmp.getSecondName(),
                dtoTmp.getFirstSurname(),
                dtoTmp.getSecondSurname(),
                cityDomainTmp,
                dtoTmp.geteMail(),
                dtoTmp.getMobileNumber(),
                dtoTmp.iseMailConfirmed(),
                dtoTmp.isMobileNumberConfirmed()
        );
    }

    @Override
    public List<UserDTO> toDTO(final List<UserDomain> domainList) {
        var userDTOList = new ArrayList<UserDTO>();

        for (var UserDomain : domainList){
            userDTOList.add((toDTO(UserDomain)));
        }
        return userDTOList;
    }
}
