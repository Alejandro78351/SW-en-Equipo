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

package co.edu.uniandes.csw.Sebastian.stadium.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.Sebastian.stadium.logic.dto.StadiumDTO;
import co.edu.uniandes.csw.Sebastian.stadium.logic.api._IStadiumLogicService;
import co.edu.uniandes.csw.Sebastian.stadium.persistence.api.IStadiumPersistence;

public abstract class _StadiumLogicService implements _IStadiumLogicService {

	@Inject
	protected IStadiumPersistence persistance;

	public StadiumDTO createStadium(StadiumDTO stadium){
		return persistance.createStadium( stadium); 
    }

	public List<StadiumDTO> getStadiums(){
		return persistance.getStadiums(); 
	}

	public StadiumDTO getStadium(Long id){
		return persistance.getStadium(id); 
	}

	public void deleteStadium(Long id){
	    persistance.deleteStadium(id); 
	}

	public void updateStadium(StadiumDTO stadium){
	    persistance.updateStadium(stadium); 
	}	
}