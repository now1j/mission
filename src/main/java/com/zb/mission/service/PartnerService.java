package com.zb.mission.service;

import com.zb.mission.entity.Partner;
import com.zb.mission.repository.PartnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    //파트너 가입
    public Partner registerPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    //모든 파트너 조회
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    //특정 파트너 조회
    public Partner getPartnerById(int id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 ID를 가진 파트너를 찾을 수 없습니다."));
    }

    //파트너 탈퇴
    public void leavePartner(int id){
        partnerRepository.deleteById(id);
    }

}
