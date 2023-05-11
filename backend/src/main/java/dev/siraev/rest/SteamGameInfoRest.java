package dev.siraev.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/steam")
public class SteamGameInfoRest {

    private final RestTemplate restTemplate;

    public SteamGameInfoRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{appId}")
    public @ResponseBody JsonNode  getSteamGameInfo(@PathVariable Long appId) throws IOException {
        String url = "https://store.steampowered.com/api/appdetails?appids=" + appId;

        ResponseEntity<String> response = restTemplate.getForEntity(url , String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode newNode = mapper.readTree(response.getBody());
        JsonNode locatedNode = newNode.path(appId.toString());

        //JsonNode rootNode = mapper.treeToValue(locatedNode, JsonNode.class);
        return locatedNode;
    }
}
