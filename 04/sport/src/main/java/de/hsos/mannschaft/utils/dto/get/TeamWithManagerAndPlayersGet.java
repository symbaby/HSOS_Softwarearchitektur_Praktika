package de.hsos.mannschaft.utils.dto.get;

import java.util.ArrayList;
import java.util.List;

public class TeamWithManagerAndPlayersGet {
    public TeamDataGet data;
    public List<IncludedGet> includedList = new ArrayList<>();

    public TeamWithManagerAndPlayersGet(){

    }
}
