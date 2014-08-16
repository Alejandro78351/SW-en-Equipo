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

package co.edu.uniandes.csw.Sebastian.championship.master.persistence.entity;

import co.edu.uniandes.csw.Sebastian.record.persistence.entity.RecordEntity;
import co.edu.uniandes.csw.Sebastian.championship.persistence.entity.ChampionShipEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(ChampionShiprecordsEntityId.class)
@NamedQueries({
    @NamedQuery(name = "ChampionShiprecordsEntity.getByMasterId", query = "SELECT  u FROM ChampionShiprecordsEntity u WHERE u.championShipId=:championShipId"),
    @NamedQuery(name = "ChampionShiprecordsEntity.deleteChampionShiprecordsEntity", query = "DELETE FROM ChampionShiprecordsEntity u WHERE u.championShipId=:championShipId and  u.recordsId=:recordsId")
})
public class ChampionShiprecordsEntity implements Serializable {

    @Id
    @Column(name = "championShipId")
    private Long championShipId;
    @Id
    @Column(name = "recordsId")
    private Long recordsId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "championShipId", referencedColumnName = "id")
    @JoinFetch
    private RecordEntity championShipIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "recordsId", referencedColumnName = "id")
    @JoinFetch
    private RecordEntity recordsIdEntity; 

    public ChampionShiprecordsEntity() {
    }

    public ChampionShiprecordsEntity(Long championShipId, Long recordsId) {
        this.championShipId =championShipId;
        this.recordsId = recordsId;
    }

    public Long getChampionShipId() {
        return championShipId;
    }

    public void setChampionShipId(Long championShipId) {
        this.championShipId = championShipId;
    }

    public Long getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(Long recordsId) {
        this.recordsId = recordsId;
    }

    public RecordEntity getChampionShipIdEntity() {
        return championShipIdEntity;
    }

    public void setChampionShipIdEntity(RecordEntity championShipIdEntity) {
        this.championShipIdEntity = championShipIdEntity;
    }

    public RecordEntity getRecordsIdEntity() {
        return recordsIdEntity;
    }

    public void setRecordsIdEntity(RecordEntity recordsIdEntity) {
        this.recordsIdEntity = recordsIdEntity;
    }

}
