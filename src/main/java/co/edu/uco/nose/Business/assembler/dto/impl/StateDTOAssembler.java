package co.edu.uco.nose.Business.assembler.dto.impl;

import co.edu.uco.nose.Business.Domain.StateDomain;
import co.edu.uco.nose.Business.assembler.dto.DTOassembler;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.StateDTO;

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
        return new StateDTO(domainTmp.getId(), countryDtoTmp, domainTmp.getName());
    }

    @Override
    public StateDomain toDomain(final StateDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new StateDTO());
        var countryDomainTmp = CountryDTOAssembler.getCountryDTOAssembler()
                .toDomain(dtoTmp.getCountry());
        return new StateDomain(dtoTmp.getId(), countryDomainTmp, dtoTmp.getName());
    }

}
