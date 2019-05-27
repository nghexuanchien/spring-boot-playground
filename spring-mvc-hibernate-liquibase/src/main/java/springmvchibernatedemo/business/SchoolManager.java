package springmvchibernatedemo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvchibernatedemo.dao.BatchDAO;
import springmvchibernatedemo.entity.Batch;
import springmvchibernatedemo.model.SchoolModel;

import java.util.List;

/**
 * @author chiennghe
 */
@Service
public class SchoolManager {
    @Autowired
    private BatchDAO batchDAO;

    public void getBatchInfo(SchoolModel schoolModel) {
        Batch selectedBatch = schoolModel.getSelectedBatch();
        List<Batch> batches = batchDAO.getBatchList();
        if(selectedBatch != null){
            Integer batchId = selectedBatch.getId();
            for(Batch batch : batches){
                if(batch.getId().equals(batchId)){
                    selectedBatch = batch;
                    break;
                }
            }
        }else{
            selectedBatch = batches.get(0);
        }
        schoolModel.setBatches(batches);
        schoolModel.setSelectedBatch(selectedBatch);
    }
}
