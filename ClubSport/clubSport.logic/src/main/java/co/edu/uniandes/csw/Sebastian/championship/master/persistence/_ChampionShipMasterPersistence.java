/* ========================================================================
 * Copyright 2014 Sebastian
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Sebastian

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.Sebastian.championship.master.persistence;
import co.edu.uniandes.csw.Sebastian.prize.logic.dto.PrizeDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipprizeEntity;
import co.edu.uniandes.csw.Sebastian.prize.persistence.converter.PrizeConverter;
import co.edu.uniandes.csw.Sebastian.record.logic.dto.RecordDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShiprecordsEntity;
import co.edu.uniandes.csw.Sebastian.record.persistence.converter.RecordConverter;
import co.edu.uniandes.csw.Sebastian.stadium.logic.dto.StadiumDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipstadiumsEntity;
import co.edu.uniandes.csw.Sebastian.stadium.persistence.converter.StadiumConverter;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShiprefereesEntity;
import co.edu.uniandes.csw.Sebastian.referee.persistence.converter.RefereeConverter;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipsecondaryRefereesEntity;
import co.edu.uniandes.csw.Sebastian.referee.persistence.converter.RefereeConverter;
import co.edu.uniandes.csw.Sebastian.championship.logic.dto.ChampionShipDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.logic.dto.ChampionShipMasterDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.api._IChampionShipMasterPersistence;
import co.edu.uniandes.csw.Sebastian.championship.persistence.api.IChampionShipPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _ChampionShipMasterPersistence implements _IChampionShipMasterPersistence {

  	@PersistenceContext(unitName="clubSportPU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected IChampionShipPersistence championshipPersistence;  

    public ChampionShipMasterDTO getChampionShip(Long championshipId) {
        ChampionShipMasterDTO championshipMasterDTO = new ChampionShipMasterDTO();
        ChampionShipDTO championship = championshipPersistence.getChampionShip(championshipId);
        championshipMasterDTO.setChampionShipEntity(championship);
        championshipMasterDTO.setListprize(getChampionShipprizeEntityList(championshipId));
        championshipMasterDTO.setListrecords(getChampionShiprecordsEntityList(championshipId));
        championshipMasterDTO.setListstadiums(getChampionShipstadiumsEntityList(championshipId));
        championshipMasterDTO.setListreferees(getChampionShiprefereesEntityList(championshipId));
        championshipMasterDTO.setListsecondaryReferees(getChampionShipsecondaryRefereesEntityList(championshipId));
        return championshipMasterDTO;
    }

    public ChampionShipprizeEntity createChampionShipprizeEntity(ChampionShipprizeEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteChampionShipprizeEntity(Long championShipId, Long prizeId) {
        Query q = entityManager.createNamedQuery("ChampionShipprizeEntity.deleteChampionShipprizeEntity");
        q.setParameter("championShipId", championShipId);
        q.setParameter("prizeId", prizeId);
        q.executeUpdate();
    }

    public List<PrizeDTO> getChampionShipprizeEntityList(Long championShipId) {
        ArrayList<PrizeDTO> resp = new ArrayList<PrizeDTO>();
        Query q = entityManager.createNamedQuery("ChampionShipprizeEntity.getByMasterId");
        q.setParameter("championShipId",championShipId);
        List<ChampionShipprizeEntity> qResult =  q.getResultList();
        for (ChampionShipprizeEntity entity : qResult) { 
            if(entity.getPrizeIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(PrizeConverter.entity2PersistenceDTO(entity.getPrizeIdEntity()));
        }
        return resp;
    }
    public ChampionShiprecordsEntity createChampionShiprecordsEntity(ChampionShiprecordsEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteChampionShiprecordsEntity(Long championShipId, Long recordsId) {
        Query q = entityManager.createNamedQuery("ChampionShiprecordsEntity.deleteChampionShiprecordsEntity");
        q.setParameter("championShipId", championShipId);
        q.setParameter("recordsId", recordsId);
        q.executeUpdate();
    }

    public List<RecordDTO> getChampionShiprecordsEntityList(Long championShipId) {
        ArrayList<RecordDTO> resp = new ArrayList<RecordDTO>();
        Query q = entityManager.createNamedQuery("ChampionShiprecordsEntity.getByMasterId");
        q.setParameter("championShipId",championShipId);
        List<ChampionShiprecordsEntity> qResult =  q.getResultList();
        for (ChampionShiprecordsEntity entity : qResult) { 
            if(entity.getRecordsIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(RecordConverter.entity2PersistenceDTO(entity.getRecordsIdEntity()));
        }
        return resp;
    }
    public ChampionShipstadiumsEntity createChampionShipstadiumsEntity(ChampionShipstadiumsEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteChampionShipstadiumsEntity(Long championShipId, Long stadiumsId) {
        Query q = entityManager.createNamedQuery("ChampionShipstadiumsEntity.deleteChampionShipstadiumsEntity");
        q.setParameter("championShipId", championShipId);
        q.setParameter("stadiumsId", stadiumsId);
        q.executeUpdate();
    }

    public List<StadiumDTO> getChampionShipstadiumsEntityList(Long championShipId) {
        ArrayList<StadiumDTO> resp = new ArrayList<StadiumDTO>();
        Query q = entityManager.createNamedQuery("ChampionShipstadiumsEntity.getByMasterId");
        q.setParameter("championShipId",championShipId);
        List<ChampionShipstadiumsEntity> qResult =  q.getResultList();
        for (ChampionShipstadiumsEntity entity : qResult) { 
            if(entity.getStadiumsIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(StadiumConverter.entity2PersistenceDTO(entity.getStadiumsIdEntity()));
        }
        return resp;
    }
    public ChampionShiprefereesEntity createChampionShiprefereesEntity(ChampionShiprefereesEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteChampionShiprefereesEntity(Long championShipId, Long refereesId) {
        Query q = entityManager.createNamedQuery("ChampionShiprefereesEntity.deleteChampionShiprefereesEntity");
        q.setParameter("championShipId", championShipId);
        q.setParameter("refereesId", refereesId);
        q.executeUpdate();
    }

    public List<RefereeDTO> getChampionShiprefereesEntityList(Long championShipId) {
        ArrayList<RefereeDTO> resp = new ArrayList<RefereeDTO>();
        Query q = entityManager.createNamedQuery("ChampionShiprefereesEntity.getByMasterId");
        q.setParameter("championShipId",championShipId);
        List<ChampionShiprefereesEntity> qResult =  q.getResultList();
        for (ChampionShiprefereesEntity entity : qResult) { 
            if(entity.getRefereesIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(RefereeConverter.entity2PersistenceDTO(entity.getRefereesIdEntity()));
        }
        return resp;
    }
    public ChampionShipsecondaryRefereesEntity createChampionShipsecondaryRefereesEntity(ChampionShipsecondaryRefereesEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteChampionShipsecondaryRefereesEntity(Long championShipId, Long secondaryRefereesId) {
        Query q = entityManager.createNamedQuery("ChampionShipsecondaryRefereesEntity.deleteChampionShipsecondaryRefereesEntity");
        q.setParameter("championShipId", championShipId);
        q.setParameter("secondaryRefereesId", secondaryRefereesId);
        q.executeUpdate();
    }

    public List<RefereeDTO> getChampionShipsecondaryRefereesEntityList(Long championShipId) {
        ArrayList<RefereeDTO> resp = new ArrayList<RefereeDTO>();
        Query q = entityManager.createNamedQuery("ChampionShipsecondaryRefereesEntity.getByMasterId");
        q.setParameter("championShipId",championShipId);
        List<ChampionShipsecondaryRefereesEntity> qResult =  q.getResultList();
        for (ChampionShipsecondaryRefereesEntity entity : qResult) { 
            if(entity.getSecondaryRefereesIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(RefereeConverter.entity2PersistenceDTO(entity.getSecondaryRefereesIdEntity()));
        }
        return resp;
    }

}
