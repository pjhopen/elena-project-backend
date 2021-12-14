package com.oakhill.elena.service.intf;

import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;

/**
* interface for PathFinderService.
*/
public interface PathFinderService {
    /**
     * Returns optimal path with respect to given arguments for a general PathFinderService
     * @param reqData Object of arguments passed from the frontend
     */
    public Path getElenaPathWithWeight(RequestData reqData);
}
