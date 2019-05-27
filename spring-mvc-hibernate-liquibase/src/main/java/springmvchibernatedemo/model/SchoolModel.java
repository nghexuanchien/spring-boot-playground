package springmvchibernatedemo.model;

import springmvchibernatedemo.entity.Batch;

import java.util.List;

public class SchoolModel {
    private Batch selectedBatch;
    private List<Batch> batches;

    public Batch getSelectedBatch() {
        return selectedBatch;
    }
    public void setSelectedBatch(Batch selectedBatch) {
        this.selectedBatch = selectedBatch;
    }
    public List<Batch> getBatches() {
        return batches;
    }
    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
