package co.edu.uco.nose.Business.assembler.dto.impl;

import co.edu.uco.nose.Business.Domain.StateDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.StateDTO;

import java.util.List;

public final class StateDTOAssembler implements DTOassembler<StateDTO,StateDomain> {

    // ✅ Instancia única (Singleton)
    private static final DTOassembler<StateDTO, StateDomain> instance = new StateDTOAssembler();

    // 🚫 Constructor privado para evitar múltiples instancias
    private StateDTOAssembler() { }

    // ✅ Método estático de acceso público
    public static DTOassembler<StateDTO, StateDomain> getStateDTOAssembler() {
        return instance;
    }

    @Override
    public StateDTO toDTO(final StateDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var countryDtoTmp = CountryDTOAssembler.getCountryDTOAssembler()
                .toDTO(domainTmp.getCountry());
        return new StateDTO(domainTmp.getId(),  domainTmp.getName(), countryDtoTmp);
    }

    @Override
    public StateDomain toDomain(final StateDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new StateDTO());
        var countryDomainTmp = CountryDTOAssembler.getCountryDTOAssembler()
                .toDomain(dtoTmp.getCountry());
        return new StateDomain(dtoTmp.getId(),dtoTmp.getName(),countryDomainTmp);
    }

    @Override
    public List<StateDTO> toDTO(List<StateDomain> domainList) {
        return List.of();
    }

}
