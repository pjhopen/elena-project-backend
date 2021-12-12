package com.oakhill.elena.service.intf;

import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;

public interface PathFinderService {
    public Path get2dShortestPathSerive(RequestData reqData);
    public Path get3ElenaPath();
    public Path get3ElenaPathWithWeight();
}
