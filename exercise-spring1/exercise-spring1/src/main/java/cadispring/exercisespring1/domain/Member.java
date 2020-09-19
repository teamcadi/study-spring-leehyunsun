package cadispring.exercisespring1.domain;

public class Member {
    private Long id; //데이터를 구분하기 위해 시스템이 지정한 id.(고객이 지정한 것이 아님)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
