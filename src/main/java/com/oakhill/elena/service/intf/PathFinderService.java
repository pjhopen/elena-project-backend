package com.oakhill.elena.service.intf;

import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;

/**
* interface for PathFinderService.
*/
public interface PathFinderService {
    public Path getElenaPathWithWeight(RequestData reqData);
}
