package com.iot.petplate.client.http;

import com.iot.petplate.dto.FeederRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${feign.client.feeder.name}", url = "${feign.client.feeder-teams.url}")
public interface BackendClient {

    @RequestMapping(method = RequestMethod.POST, value = "${feign.client.feeder.resource.add}")
    void sendDataFeeder(@RequestBody List<FeederRequestDTO> dto);

}
