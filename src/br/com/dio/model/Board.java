package br.com.dio.model;

import java.util.Collection;
import java.util.List;

import static br.com.dio.model.GameStatusEnum.COMPLETE;
import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {
    private final List<List<Space>> spaces;

    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getStatus() {
        if (spaces.stream()
                    .flatMap(Collection::stream)
                    .noneMatch(s -> !s.isFixed()
                    &&
                    nonNull(s.getActal()))) {
            return NON_STARTED;
        } else {
            return spaces.stream()
                            .flatMap(Collection::stream)
                            .anyMatch(s -> isNull(s.getActal())) 
                            ?
                            INCOMPLETE
                            :
                            COMPLETE;
        }
    }

    public boolean hasErrors() {
        if (getStatus() == NON_STARTED) {
            return false;
        } else {
            return spaces.stream()
                            .flatMap(Collection::stream)
                            .anyMatch(s -> nonNull(s.getActal()) 
                            &&
                            !s.getActal().equals(s.getExpected()));
        }
    }

    public boolean changeValue(final int col, final int row, final Integer value) {
        var space = spaces.get(col).get(row);

        if (space.isFixed()) {
            return false;
        } else {
            space.setActal(value);
            return true;
        }
    }

    public boolean clearValue(final int col, final int row) {
        var space = spaces.get(col).get(row);

        if (space.isFixed()) {
            return false;
        } else {
            space.clearSpace();
            return true;
        }
    }
    
    public void reset() {
        spaces.forEach(c -> c.forEach(r -> r.clearSpace()));
    }

    public boolean gamesIsFinished() {
        return !hasErrors() && getStatus().equals(COMPLETE);
    }
}
