package co.edu.uco.nose.Business.assembler.dto.impl;

import co.edu.uco.nose.Business.Domain.IdTypeDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.IdTypeDTO;

import java.util.List;

public final class IdTypeDTOAssembler implements DTOassembler<IdTypeDTO, IdTypeDomain> {

    // ✅ Instancia única (Singleton)
    private static final DTOassembler<IdTypeDTO, IdTypeDomain> instance = new IdTypeDTOAssembler();

    // 🚫 Constructor privado para evitar instanciación externa
    private IdTypeDTOAssembler() { }

    // ✅ Método de acceso público a la instancia
    public static DTOassembler<IdTypeDTO, IdTypeDomain> getIdTypeDTOAssembler() {
        return instance;
    }

    @Override
    public IdTypeDTO toDTO(final IdTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdTypeDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public IdTypeDomain toDomain(final IdTypeDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new IdTypeDTO());
        return new IdTypeDomain(dtoTmp.getId(), dtoTmp.getName());
    }

    @Override
    public List<IdTypeDTO> toDTO(List<IdTypeDomain> domainList) {
        return List.of();
    }
}
