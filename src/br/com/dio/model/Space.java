package br.com.dio.model;

public class Space {
    private Integer actal;
    private final int expected;
    private final boolean fixed;

    public Space(final int expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;

        if (fixed) {
            actal = expected;
        }
    }

    public Integer getActal() {
        return actal;
    }

    public void setActal(Integer actal) {
        if (fixed) {
            return;
        }
        this.actal = actal;
    }

    public void clearSpace() {
        setActal(null);
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }

    
}
