package server.mypage.api.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import server.favoritePlace.api.response.FavoritePlaceResDto;
import server.placeReview.api.response.PlaceReviewResDto;
import server.tip.api.dto.response.PostResponse;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MypageResponse(
        String name,
        String profileImage,
        String email,
        String createdAt
) {}