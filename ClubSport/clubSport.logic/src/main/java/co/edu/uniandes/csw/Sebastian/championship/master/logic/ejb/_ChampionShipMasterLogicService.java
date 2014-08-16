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

package co.edu.uniandes.csw.Sebastian.championship.master.logic.ejb;

import co.edu.uniandes.csw.Sebastian.prize.logic.dto.PrizeDTO;
import co.edu.uniandes.csw.Sebastian.prize.persistence.api.IPrizePersistence;
import co.edu.uniandes.csw.Sebastian.record.logic.dto.RecordDTO;
import co.edu.uniandes.csw.Sebastian.record.persistence.api.IRecordPersistence;
import co.edu.uniandes.csw.Sebastian.stadium.logic.dto.StadiumDTO;
import co.edu.uniandes.csw.Sebastian.stadium.persistence.api.IStadiumPersistence;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.referee.persistence.api.IRefereePersistence;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.referee.persistence.api.IRefereePersistence;
import co.edu.uniandes.csw.Sebastian.championship.logic.dto.ChampionShipDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.logic.api._IChampionShipMasterLogicService;
import co.edu.uniandes.csw.Sebastian.championship.master.logic.dto.ChampionShipMasterDTO;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.api.IChampionShipMasterPersistence;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipprizeEntity;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShiprecordsEntity;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipstadiumsEntity;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShiprefereesEntity;
import co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity.ChampionShipsecondaryRefereesEntity;
import co.edu.uniandes.csw.Sebastian.championship.persistence.api.IChampionShipPersistence;
import javax.inject.Inject;

public abstract class _ChampionShipMasterLogicService implements _IChampionShipMasterLogicService {

    @Inject
    protected IChampionShipPersistence championshipPersistance;
    @Inject
    protected IChampionShipMasterPersistence championshipMasterPersistance;
    @Inject
    protected IRefereePersistence refereePersistance;
    @Inject
    protected IStadiumPersistence stadiumPersistance;
    @Inject
    protected IRecordPersistence recordPersistance;
    @Inject
    protected IPrizePersistence prizePersistance;

    public ChampionShipMasterDTO createMasterChampionShip(ChampionShipMasterDTO championship) {
        ChampionShipDTO persistedChampionShipDTO = championshipPersistance.createChampionShip(championship.getChampionShipEntity());
        if (championship.getCreateprize() != null) {
            for (PrizeDTO prizeDTO : championship.getCreateprize()) {
                PrizeDTO createdPrizeDTO = prizePersistance.createPrize(prizeDTO);
                ChampionShipprizeEntity championshipPrizeEntity = new ChampionShipprizeEntity(persistedChampionShipDTO.getId(), createdPrizeDTO.getId());
                championshipMasterPersistance.createChampionShipprizeEntity(championshipPrizeEntity);
            }
        }
        if (championship.getCreaterecords() != null) {
            for (RecordDTO recordDTO : championship.getCreaterecords()) {
                RecordDTO createdRecordDTO = recordPersistance.createRecord(recordDTO);
                ChampionShiprecordsEntity championshipRecordEntity = new ChampionShiprecordsEntity(persistedChampionShipDTO.getId(), createdRecordDTO.getId());
                championshipMasterPersistance.createChampionShiprecordsEntity(championshipRecordEntity);
            }
        }
        if (championship.getCreatestadiums() != null) {
            for (StadiumDTO stadiumDTO : championship.getCreatestadiums()) {
                StadiumDTO createdStadiumDTO = stadiumPersistance.createStadium(stadiumDTO);
                ChampionShipstadiumsEntity championshipStadiumEntity = new ChampionShipstadiumsEntity(persistedChampionShipDTO.getId(), createdStadiumDTO.getId());
                championshipMasterPersistance.createChampionShipstadiumsEntity(championshipStadiumEntity);
            }
        }
        if (championship.getCreatereferees() != null) {
            for (RefereeDTO refereeDTO : championship.getCreatereferees()) {
                RefereeDTO createdRefereeDTO = refereePersistance.createReferee(refereeDTO);
                ChampionShiprefereesEntity championshipRefereeEntity = new ChampionShiprefereesEntity(persistedChampionShipDTO.getId(), createdRefereeDTO.getId());
                championshipMasterPersistance.createChampionShiprefereesEntity(championshipRefereeEntity);
            }
        }
        if (championship.getCreatesecondaryReferees() != null) {
            for (RefereeDTO refereeDTO : championship.getCreatesecondaryReferees()) {
                RefereeDTO createdRefereeDTO = refereePersistance.createReferee(refereeDTO);
                ChampionShipsecondaryRefereesEntity championshipRefereeEntity = new ChampionShipsecondaryRefereesEntity(persistedChampionShipDTO.getId(), createdRefereeDTO.getId());
                championshipMasterPersistance.createChampionShipsecondaryRefereesEntity(championshipRefereeEntity);
            }
        }
        // update prize
        if (championship.getUpdateprize() != null) {
            for (PrizeDTO prizeDTO : championship.getUpdateprize()) {
                prizePersistance.updatePrize(prizeDTO);
                ChampionShipprizeEntity championshipPrizeEntity = new ChampionShipprizeEntity(persistedChampionShipDTO.getId(), prizeDTO.getId());
                championshipMasterPersistance.createChampionShipprizeEntity(championshipPrizeEntity);
            }
        }
        // update record
        if (championship.getUpdaterecords() != null) {
            for (RecordDTO recordDTO : championship.getUpdaterecords()) {
                recordPersistance.updateRecord(recordDTO);
                ChampionShiprecordsEntity championshipRecordEntity = new ChampionShiprecordsEntity(persistedChampionShipDTO.getId(), recordDTO.getId());
                championshipMasterPersistance.createChampionShiprecordsEntity(championshipRecordEntity);
            }
        }
        // update stadium
        if (championship.getUpdatestadiums() != null) {
            for (StadiumDTO stadiumDTO : championship.getUpdatestadiums()) {
                stadiumPersistance.updateStadium(stadiumDTO);
                ChampionShipstadiumsEntity championshipStadiumEntity = new ChampionShipstadiumsEntity(persistedChampionShipDTO.getId(), stadiumDTO.getId());
                championshipMasterPersistance.createChampionShipstadiumsEntity(championshipStadiumEntity);
            }
        }
        // update referee
        if (championship.getUpdatereferees() != null) {
            for (RefereeDTO refereeDTO : championship.getUpdatereferees()) {
                refereePersistance.updateReferee(refereeDTO);
                ChampionShiprefereesEntity championshipRefereeEntity = new ChampionShiprefereesEntity(persistedChampionShipDTO.getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShiprefereesEntity(championshipRefereeEntity);
            }
        }
        // update referee
        if (championship.getUpdatesecondaryReferees() != null) {
            for (RefereeDTO refereeDTO : championship.getUpdatesecondaryReferees()) {
                refereePersistance.updateReferee(refereeDTO);
                ChampionShipsecondaryRefereesEntity championshipRefereeEntity = new ChampionShipsecondaryRefereesEntity(persistedChampionShipDTO.getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShipsecondaryRefereesEntity(championshipRefereeEntity);
            }
        }
        return championship;
    }

    public ChampionShipMasterDTO getMasterChampionShip(Long id) {
        return championshipMasterPersistance.getChampionShip(id);
    }

    public void deleteMasterChampionShip(Long id) {
        championshipPersistance.deleteChampionShip(id);
    }

    public void updateMasterChampionShip(ChampionShipMasterDTO championship) {
        championshipPersistance.updateChampionShip(championship.getChampionShipEntity());

        //---- FOR RELATIONSHIP
        // persist new prize
        if (championship.getCreateprize() != null) {
            for (PrizeDTO prizeDTO : championship.getCreateprize()) {
                PrizeDTO createdPrizeDTO = prizePersistance.createPrize(prizeDTO);
                ChampionShipprizeEntity championshipPrizeEntity = new ChampionShipprizeEntity(championship.getChampionShipEntity().getId(), createdPrizeDTO.getId());
                championshipMasterPersistance.createChampionShipprizeEntity(championshipPrizeEntity);
            }
        }
        // update prize
        if (championship.getUpdateprize() != null) {
            for (PrizeDTO prizeDTO : championship.getUpdateprize()) {
                prizePersistance.updatePrize(prizeDTO);
            }
        }
        // delete prize
        if (championship.getDeleteprize() != null) {
            for (PrizeDTO prizeDTO : championship.getDeleteprize()) {
                championshipMasterPersistance.deleteChampionShipprizeEntity(championship.getChampionShipEntity().getId(), prizeDTO.getId());
                prizePersistance.deletePrize(prizeDTO.getId());
            }
        }
        // persist new record
        if (championship.getCreaterecords() != null) {
            for (RecordDTO recordDTO : championship.getCreaterecords()) {
                RecordDTO createdRecordDTO = recordPersistance.createRecord(recordDTO);
                ChampionShiprecordsEntity championshipRecordEntity = new ChampionShiprecordsEntity(championship.getChampionShipEntity().getId(), createdRecordDTO.getId());
                championshipMasterPersistance.createChampionShiprecordsEntity(championshipRecordEntity);
            }
        }
        // update record
        if (championship.getUpdaterecords() != null) {
            for (RecordDTO recordDTO : championship.getUpdaterecords()) {
                recordPersistance.updateRecord(recordDTO);
            }
        }
        // delete record
        if (championship.getDeleterecords() != null) {
            for (RecordDTO recordDTO : championship.getDeleterecords()) {
                championshipMasterPersistance.deleteChampionShiprecordsEntity(championship.getChampionShipEntity().getId(), recordDTO.getId());
                recordPersistance.deleteRecord(recordDTO.getId());
            }
        }
        // delete stadium
        if (championship.getDeletestadiums() != null) {
            for (StadiumDTO stadiumDTO : championship.getDeletestadiums()) {
                championshipMasterPersistance.deleteChampionShipstadiumsEntity(championship.getChampionShipEntity().getId(), stadiumDTO.getId());
            }
        }
        // persist new stadium
        if (championship.getCreatestadiums() != null) {
            for (StadiumDTO stadiumDTO : championship.getCreatestadiums()) {
                ChampionShipstadiumsEntity championshipStadiumEntity = new ChampionShipstadiumsEntity(championship.getChampionShipEntity().getId(), stadiumDTO.getId());
                championshipMasterPersistance.createChampionShipstadiumsEntity(championshipStadiumEntity);
            }
        }
        // update stadium
        if (championship.getUpdatestadiums() != null) {
            for (StadiumDTO stadiumDTO : championship.getUpdatestadiums()) {
                championshipMasterPersistance.deleteChampionShipstadiumsEntity(championship.getChampionShipEntity().getId(), stadiumDTO.getId());
                stadiumPersistance.updateStadium(stadiumDTO);
                ChampionShipstadiumsEntity championshipStadiumEntity = new ChampionShipstadiumsEntity(championship.getId(), stadiumDTO.getId());
                championshipMasterPersistance.createChampionShipstadiumsEntity(championshipStadiumEntity);
                
            }
        }
        // delete referee
        if (championship.getDeletereferees() != null) {
            for (RefereeDTO refereeDTO : championship.getDeletereferees()) {
                championshipMasterPersistance.deleteChampionShiprefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
            }
        }
        // persist new referee
        if (championship.getCreatereferees() != null) {
            for (RefereeDTO refereeDTO : championship.getCreatereferees()) {
                ChampionShiprefereesEntity championshipRefereeEntity = new ChampionShiprefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShiprefereesEntity(championshipRefereeEntity);
            }
        }
        // update referee
        if (championship.getUpdatereferees() != null) {
            for (RefereeDTO refereeDTO : championship.getUpdatereferees()) {
                championshipMasterPersistance.deleteChampionShiprefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
                refereePersistance.updateReferee(refereeDTO);
                ChampionShiprefereesEntity championshipRefereeEntity = new ChampionShiprefereesEntity(championship.getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShiprefereesEntity(championshipRefereeEntity);
                
            }
        }
        // delete referee
        if (championship.getDeletesecondaryReferees() != null) {
            for (RefereeDTO refereeDTO : championship.getDeletesecondaryReferees()) {
                championshipMasterPersistance.deleteChampionShipsecondaryRefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
            }
        }
        // persist new referee
        if (championship.getCreatesecondaryReferees() != null) {
            for (RefereeDTO refereeDTO : championship.getCreatesecondaryReferees()) {
                ChampionShipsecondaryRefereesEntity championshipRefereeEntity = new ChampionShipsecondaryRefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShipsecondaryRefereesEntity(championshipRefereeEntity);
            }
        }
        // update referee
        if (championship.getUpdatesecondaryReferees() != null) {
            for (RefereeDTO refereeDTO : championship.getUpdatesecondaryReferees()) {
                championshipMasterPersistance.deleteChampionShipsecondaryRefereesEntity(championship.getChampionShipEntity().getId(), refereeDTO.getId());
                refereePersistance.updateReferee(refereeDTO);
                ChampionShipsecondaryRefereesEntity championshipRefereeEntity = new ChampionShipsecondaryRefereesEntity(championship.getId(), refereeDTO.getId());
                championshipMasterPersistance.createChampionShipsecondaryRefereesEntity(championshipRefereeEntity);
                
            }
        }
    }
}
