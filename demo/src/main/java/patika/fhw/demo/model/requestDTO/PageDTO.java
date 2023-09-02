package patika.fhw.demo.model.requestDTO;
import java.util.List;

import patika.fhw.demo.util.dbutil.BaseDTO;

public class PageDTO<DTO> extends BaseDTO {
    private List<DTO> content;
    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int size;
    public List<DTO> getContent() {
        return content;
    }
    public void setContent(List<DTO> content) {
        this.content = content;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    
}
