package server.place.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.place.api.dto.response.PlaceListResDto;
import server.place.api.dto.response.PlaceResDto;
import server.place.api.dto.response.PlaceResDtoForTop;
import server.place.application.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    // 장소 전체 조회
    @GetMapping
    public PlaceListResDto getAllPlaces() {
        return placeService.placeFindAll();
    }

    // placeId로 장소 한 개 조회
    @GetMapping("/{placeId}")
    public PlaceResDto getPlaceById(@PathVariable Long placeId) {
        return placeService.placeFindOne(placeId);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<PlaceResDtoForTop>> getTop5Places() {
        return ResponseEntity.ok(placeService.getTop5ByAverageRating());
    }

}
