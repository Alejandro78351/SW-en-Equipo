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

package co.edu.uniandes.csw.Sebastian.championship.master.logic.dto;

import co.edu.uniandes.csw.Sebastian.prize.logic.dto.PrizeDTO;
import co.edu.uniandes.csw.Sebastian.record.logic.dto.RecordDTO;
import co.edu.uniandes.csw.Sebastian.stadium.logic.dto.StadiumDTO;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.referee.logic.dto.RefereeDTO;
import co.edu.uniandes.csw.Sebastian.championship.logic.dto.ChampionShipDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _ChampionShipMasterDTO {

 
    protected ChampionShipDTO championshipEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ChampionShipDTO getChampionShipEntity() {
        return championshipEntity;
    }

    public void setChampionShipEntity(ChampionShipDTO championshipEntity) {
        this.championshipEntity = championshipEntity;
    }
    
    public List<PrizeDTO> createprize;
    public List<PrizeDTO> updateprize;
    public List<PrizeDTO> deleteprize;
    public List<PrizeDTO> listprize;	
    public List<RecordDTO> createrecords;
    public List<RecordDTO> updaterecords;
    public List<RecordDTO> deleterecords;
    public List<RecordDTO> listrecords;	
    public List<StadiumDTO> createstadiums;
    public List<StadiumDTO> updatestadiums;
    public List<StadiumDTO> deletestadiums;
    public List<StadiumDTO> liststadiums;	
    public List<RefereeDTO> createreferees;
    public List<RefereeDTO> updatereferees;
    public List<RefereeDTO> deletereferees;
    public List<RefereeDTO> listreferees;	
    public List<RefereeDTO> createsecondaryReferees;
    public List<RefereeDTO> updatesecondaryReferees;
    public List<RefereeDTO> deletesecondaryReferees;
    public List<RefereeDTO> listsecondaryReferees;	
	
	
	
    public List<PrizeDTO> getCreateprize(){ return createprize; };
    public void setCreateprize(List<PrizeDTO> createprize){ this.createprize=createprize; };
    public List<PrizeDTO> getUpdateprize(){ return updateprize; };
    public void setUpdateprize(List<PrizeDTO> updateprize){ this.updateprize=updateprize; };
    public List<PrizeDTO> getDeleteprize(){ return deleteprize; };
    public void setDeleteprize(List<PrizeDTO> deleteprize){ this.deleteprize=deleteprize; };
    public List<PrizeDTO> getListprize(){ return listprize; };
    public void setListprize(List<PrizeDTO> listprize){ this.listprize=listprize; };	
    public List<RecordDTO> getCreaterecords(){ return createrecords; };
    public void setCreaterecords(List<RecordDTO> createrecords){ this.createrecords=createrecords; };
    public List<RecordDTO> getUpdaterecords(){ return updaterecords; };
    public void setUpdaterecords(List<RecordDTO> updaterecords){ this.updaterecords=updaterecords; };
    public List<RecordDTO> getDeleterecords(){ return deleterecords; };
    public void setDeleterecords(List<RecordDTO> deleterecords){ this.deleterecords=deleterecords; };
    public List<RecordDTO> getListrecords(){ return listrecords; };
    public void setListrecords(List<RecordDTO> listrecords){ this.listrecords=listrecords; };	
    public List<StadiumDTO> getCreatestadiums(){ return createstadiums; };
    public void setCreatestadiums(List<StadiumDTO> createstadiums){ this.createstadiums=createstadiums; };
    public List<StadiumDTO> getUpdatestadiums(){ return updatestadiums; };
    public void setUpdatestadiums(List<StadiumDTO> updatestadiums){ this.updatestadiums=updatestadiums; };
    public List<StadiumDTO> getDeletestadiums(){ return deletestadiums; };
    public void setDeletestadiums(List<StadiumDTO> deletestadiums){ this.deletestadiums=deletestadiums; };
    public List<StadiumDTO> getListstadiums(){ return liststadiums; };
    public void setListstadiums(List<StadiumDTO> liststadiums){ this.liststadiums=liststadiums; };	
    public List<RefereeDTO> getCreatereferees(){ return createreferees; };
    public void setCreatereferees(List<RefereeDTO> createreferees){ this.createreferees=createreferees; };
    public List<RefereeDTO> getUpdatereferees(){ return updatereferees; };
    public void setUpdatereferees(List<RefereeDTO> updatereferees){ this.updatereferees=updatereferees; };
    public List<RefereeDTO> getDeletereferees(){ return deletereferees; };
    public void setDeletereferees(List<RefereeDTO> deletereferees){ this.deletereferees=deletereferees; };
    public List<RefereeDTO> getListreferees(){ return listreferees; };
    public void setListreferees(List<RefereeDTO> listreferees){ this.listreferees=listreferees; };	
    public List<RefereeDTO> getCreatesecondaryReferees(){ return createsecondaryReferees; };
    public void setCreatesecondaryReferees(List<RefereeDTO> createsecondaryReferees){ this.createsecondaryReferees=createsecondaryReferees; };
    public List<RefereeDTO> getUpdatesecondaryReferees(){ return updatesecondaryReferees; };
    public void setUpdatesecondaryReferees(List<RefereeDTO> updatesecondaryReferees){ this.updatesecondaryReferees=updatesecondaryReferees; };
    public List<RefereeDTO> getDeletesecondaryReferees(){ return deletesecondaryReferees; };
    public void setDeletesecondaryReferees(List<RefereeDTO> deletesecondaryReferees){ this.deletesecondaryReferees=deletesecondaryReferees; };
    public List<RefereeDTO> getListsecondaryReferees(){ return listsecondaryReferees; };
    public void setListsecondaryReferees(List<RefereeDTO> listsecondaryReferees){ this.listsecondaryReferees=listsecondaryReferees; };	
	
	
}

