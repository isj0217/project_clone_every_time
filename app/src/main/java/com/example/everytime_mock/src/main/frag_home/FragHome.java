package com.example.everytime_mock.src.main.frag_home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.everytime_mock.R;
import com.example.everytime_mock.src.boards.hot_board.HotBoardActivity;
import com.example.everytime_mock.src.boards.lecture_review.LectureReviewInSubjectActivity;
import com.example.everytime_mock.src.boards.lecture_review.RecentLectureReviewBoardActivity;
import com.example.everytime_mock.src.boards.in_post.InPostActivity;
import com.example.everytime_mock.src.boards.models.common_board.CommonBoardResponse;
import com.example.everytime_mock.src.main.frag_home.models.AdvertisementResponse;
import com.example.everytime_mock.src.main.frag_home.models.HotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RealTimeHotPostResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResponse;
import com.example.everytime_mock.src.main.frag_home.models.RecentLectureReviewResult;
import com.example.everytime_mock.src.main.frag_home.my_page.MyPageActivity;
import com.example.everytime_mock.src.main.frag_home.interfaces.FragHomeView;
import com.example.everytime_mock.src.main.frag_home.models.FavoriteBoardAdapter;
import com.example.everytime_mock.src.main.frag_home.models.FavoriteBoardItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FragHome extends Fragment implements FragHomeView {
    ViewGroup viewGroup;

    private LinearLayout linear_layout_frag_home_univ_homepage, linear_layout_frag_home_shuttle_bus, linear_layout_frag_home_notificaition,
            linear_layout_frag_home_schedule, linear_layout_frag_home_library, linear_layout_frag_home_web_mail;

    private ArrayList<FavoriteBoardItem> favorite_board_item_list;
    private FavoriteBoardAdapter favorite_board_adapter;
    private RecyclerView rv_favorite_board;
    private LinearLayoutManager linear_layout_manager;

    private TextView tv_frag_home_favorite_free_board_first_post, tv_frag_home_favorite_secret_board_first_post,
            tv_frag_home_favorite_alumni_board_first_post, tv_frag_home_favorite_freshmen_board_first_post;

    private TextView tv_frag_home_realtime_hot_post_1_user_name,
            tv_frag_home_realtime_hot_post_1_date,
            tv_frag_home_realtime_hot_post_1_title,
            tv_frag_home_realtime_hot_post_1_content,
            tv_frag_home_realtime_hot_post_1_board_type,
            tv_frag_home_realtime_hot_post_1_like_num,
            tv_frag_home_realtime_hot_post_1_comment_num;

    private TextView tv_frag_home_realtime_hot_post_2_user_name,
            tv_frag_home_realtime_hot_post_2_date,
            tv_frag_home_realtime_hot_post_2_title,
            tv_frag_home_realtime_hot_post_2_content,
            tv_frag_home_realtime_hot_post_2_board_type,
            tv_frag_home_realtime_hot_post_2_like_num,
            tv_frag_home_realtime_hot_post_2_comment_num;

    private TextView tv_frag_home_hot_post_1_title, tv_frag_home_hot_post_1_time, tv_frag_home_hot_post_1_like_num, tv_frag_home_hot_post_1_comment_num;
    private TextView tv_frag_home_hot_post_2_title, tv_frag_home_hot_post_2_time, tv_frag_home_hot_post_2_like_num, tv_frag_home_hot_post_2_comment_num;
    private TextView tv_frag_home_hot_post_3_title, tv_frag_home_hot_post_3_time, tv_frag_home_hot_post_3_like_num, tv_frag_home_hot_post_3_comment_num;
    private TextView tv_frag_home_hot_post_4_title, tv_frag_home_hot_post_4_time, tv_frag_home_hot_post_4_like_num, tv_frag_home_hot_post_4_comment_num;

    private TextView tv_frag_home_recent_lecture_review_1_subject, tv_frag_home_recent_lecture_review_1_professor, tv_frag_home_recent_lecture_review_1_content,
            tv_frag_home_recent_lecture_review_2_subject, tv_frag_home_recent_lecture_review_2_professor, tv_frag_home_recent_lecture_review_2_content,
            tv_frag_home_recent_lecture_review_3_subject, tv_frag_home_recent_lecture_review_3_professor, tv_frag_home_recent_lecture_review_3_content,
            tv_frag_home_recent_lecture_review_4_subject, tv_frag_home_recent_lecture_review_4_professor, tv_frag_home_recent_lecture_review_4_content;

    private ImageView iv_frag_home_recent_lecture_review_1_rank, iv_frag_home_recent_lecture_review_2_rank,
            iv_frag_home_recent_lecture_review_3_rank, iv_frag_home_recent_lecture_review_4_rank;

    private ImageView iv_frag_home_advertisement;

    private LinearLayout linear_layout_frag_home_hot_board_more, linear_layout_frag_home_recent_lecture_review_more;

    private LinearLayout linear_layout_frag_home_realtime_hot_post_1, linear_layout_frag_home_realtime_hot_post_2,
            linear_layout_frag_home_hot_post_1, linear_layout_frag_home_hot_post_2,
            linear_layout_frag_home_hot_post_3, linear_layout_frag_home_hot_post_4,
            linear_layout_frag_home_recent_lecture_review_1, linear_layout_frag_home_recent_lecture_review_2,
            linear_layout_frag_home_recent_lecture_review_3, linear_layout_frag_home_recent_lecture_review_4;

    private LinearLayout linear_layout_frag_home_favorite_free_board, linear_layout_frag_home_favorite_secret_board,
            linear_layout_frag_home_favorite_alumni_board, linear_layout_frag_home_favorite_freshmen_board;

    public void tryGetFirstFreeBoardPost() {
        FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getFirstFreeBoardPost();
    }

    public void tryGetFirstSecretBoardPost() {
        FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getFirstSecretBoardPost();
    }
    public void tryGetFirstAlumniBoardPost() {
        FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getFirstAlumniBoardPost();

    }
    public void tryGetFirstFreshmenBoardPost() {
        FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getFirstFreshmenBoardPost();
    }

    public void viewBindFavoriteBoardLinearLayouts() {
        linear_layout_frag_home_favorite_free_board = viewGroup.findViewById(R.id.linear_layout_frag_home_favorite_free_board);
        linear_layout_frag_home_favorite_free_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "frag_home_favorite_free_board");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_favorite_secret_board = viewGroup.findViewById(R.id.linear_layout_frag_home_favorite_secret_board);
        linear_layout_frag_home_favorite_secret_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "frag_home_favorite_secret_board");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_favorite_alumni_board = viewGroup.findViewById(R.id.linear_layout_frag_home_favorite_alumni_board);
        linear_layout_frag_home_favorite_alumni_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "frag_home_favorite_alumni_board");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_favorite_freshmen_board = viewGroup.findViewById(R.id.linear_layout_frag_home_favorite_freshmen_board);
        linear_layout_frag_home_favorite_freshmen_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "frag_home_favorite_freshmen_board");
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.frag_home, container, false);

        viewBindRealTimeHotPost();
        viewBindHotPost();
        viewBindRecentLectureReviews();

        linkIconsToWebSites();

        viewBindFavoriteBoardTextViews();
        viewBindFavoriteBoardLinearLayouts();

        tryGetFirstFreeBoardPost();
        tryGetFirstSecretBoardPost();
        tryGetFirstAlumniBoardPost();
        tryGetFirstFreshmenBoardPost();

        iv_frag_home_advertisement = viewGroup.findViewById(R.id.iv_frag_home_advertisement);


        viewBindLinearLayout();



        linear_layout_frag_home_hot_board_more = viewGroup.findViewById(R.id.linear_layout_frag_home_hot_board_more);
        linear_layout_frag_home_hot_board_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HotBoardActivity.class);
                startActivity(intent);
            }
        });

        linear_layout_frag_home_recent_lecture_review_more = viewGroup.findViewById(R.id.linear_layout_frag_home_recent_lecture_review_more);
        linear_layout_frag_home_recent_lecture_review_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecentLectureReviewBoardActivity.class);
                startActivity(intent);
            }
        });


        ImageView myPage = viewGroup.findViewById(R.id.iv_frag_home_my_page);
        myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MyPageActivity.class);
                startActivity(intent);
            }
        });

        linear_layout_manager = new LinearLayoutManager(viewGroup.getContext());

        favorite_board_item_list = new ArrayList<>();
        favorite_board_adapter = new FavoriteBoardAdapter(favorite_board_item_list);


        tryGetAdvertisement();
        tryGetRealTimeHotPost();
        tryGetHotPost();
        tryGetRecentLectureReview();

        return viewGroup;
    }

    public void viewBindFavoriteBoardTextViews() {
        tv_frag_home_favorite_free_board_first_post = viewGroup.findViewById(R.id.tv_frag_home_favorite_free_board_first_post);
        tv_frag_home_favorite_secret_board_first_post = viewGroup.findViewById(R.id.tv_frag_home_favorite_secret_board_first_post);
        tv_frag_home_favorite_alumni_board_first_post = viewGroup.findViewById(R.id.tv_frag_home_favorite_alumni_board_first_post);
        tv_frag_home_favorite_freshmen_board_first_post = viewGroup.findViewById(R.id.tv_frag_home_favorite_freshmen_board_first_post);
    }

    private void tryGetAdvertisement() {
        final FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getAdvertisement();
    }

    private void tryGetHotPost() {
        final FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getHotPost();
    }

    private void tryGetRealTimeHotPost() {
        final FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getRealTimeHotPost();
    }

    private void tryGetRecentLectureReview() {
        final FragHomeService fragHomeService = new FragHomeService(this);
        fragHomeService.getRecentLectureReview();
    }


    public int convertDoubleRateToDiscreteInt(RecentLectureReviewResult recentLectureReviewResult) {
        int int_rate = 0;
        double double_rate = recentLectureReviewResult.getClassStar();
        if (double_rate <= 0.5) {
            int_rate = 1;
        } else if (double_rate <= 1) {
            int_rate = 2;
        } else if (double_rate <= 1.5) {
            int_rate = 3;
        } else if (double_rate <= 2) {
            int_rate = 4;
        } else if (double_rate <= 2.5) {
            int_rate = 5;
        } else if (double_rate <= 3) {
            int_rate = 6;
        } else if (double_rate <= 3.5) {
            int_rate = 7;
        } else if (double_rate <= 4) {
            int_rate = 8;
        } else if (double_rate <= 4.5) {
            int_rate = 9;
        } else if (double_rate <= 5) {
            int_rate = 10;
        }
        return int_rate;
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void advertisementSuccess(AdvertisementResponse advertisementResponse) {

        final String adThumbnail = advertisementResponse.getAdvertisementResults().get(0).getAdThumbnaillURL();
        iv_frag_home_advertisement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adThumbnail));
                startActivity(intent);
            }
        });

        new DownloadAdsTask().execute(adThumbnail);
    }

    private class DownloadAdsTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            iv_frag_home_advertisement.setImageBitmap(result);
        }
    }

    public void viewBindRealTimeHotPost() {
        tv_frag_home_realtime_hot_post_1_user_name = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_user_name);
        tv_frag_home_realtime_hot_post_1_date = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_date);
        tv_frag_home_realtime_hot_post_1_title = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_title);
        tv_frag_home_realtime_hot_post_1_content = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_content);
        tv_frag_home_realtime_hot_post_1_board_type = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_board_type);
        tv_frag_home_realtime_hot_post_1_like_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_like_num);
        tv_frag_home_realtime_hot_post_1_comment_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_1_comment_num);

        tv_frag_home_realtime_hot_post_2_user_name = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_user_name);
        tv_frag_home_realtime_hot_post_2_date = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_date);
        tv_frag_home_realtime_hot_post_2_title = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_title);
        tv_frag_home_realtime_hot_post_2_content = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_content);
        tv_frag_home_realtime_hot_post_2_board_type = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_board_type);
        tv_frag_home_realtime_hot_post_2_like_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_like_num);
        tv_frag_home_realtime_hot_post_2_comment_num = viewGroup.findViewById(R.id.tv_frag_home_realtime_hot_post_2_comment_num);
    }

    public void viewBindHotPost() {
        tv_frag_home_hot_post_1_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_title);
        tv_frag_home_hot_post_1_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_time);
        tv_frag_home_hot_post_1_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_like_num);
        tv_frag_home_hot_post_1_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_1_comment_num);

        tv_frag_home_hot_post_2_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_title);
        tv_frag_home_hot_post_2_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_time);
        tv_frag_home_hot_post_2_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_like_num);
        tv_frag_home_hot_post_2_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_2_comment_num);

        tv_frag_home_hot_post_3_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_title);
        tv_frag_home_hot_post_3_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_time);
        tv_frag_home_hot_post_3_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_like_num);
        tv_frag_home_hot_post_3_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_3_comment_num);

        tv_frag_home_hot_post_4_title = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_title);
        tv_frag_home_hot_post_4_time = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_time);
        tv_frag_home_hot_post_4_like_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_like_num);
        tv_frag_home_hot_post_4_comment_num = viewGroup.findViewById(R.id.tv_frag_home_hot_post_4_comment_num);
    }

    public void viewBindRecentLectureReviews() {
        iv_frag_home_recent_lecture_review_1_rank = viewGroup.findViewById(R.id.iv_frag_home_recent_lecture_review_1_rank);
        tv_frag_home_recent_lecture_review_1_subject = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_1_subject);
        tv_frag_home_recent_lecture_review_1_professor = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_1_professor);
        tv_frag_home_recent_lecture_review_1_content = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_1_content);

        iv_frag_home_recent_lecture_review_2_rank = viewGroup.findViewById(R.id.iv_frag_home_recent_lecture_review_2_rank);
        tv_frag_home_recent_lecture_review_2_subject = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_2_subject);
        tv_frag_home_recent_lecture_review_2_professor = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_2_professor);
        tv_frag_home_recent_lecture_review_2_content = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_2_content);

        iv_frag_home_recent_lecture_review_3_rank = viewGroup.findViewById(R.id.iv_frag_home_recent_lecture_review_3_rank);
        tv_frag_home_recent_lecture_review_3_subject = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_3_subject);
        tv_frag_home_recent_lecture_review_3_professor = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_3_professor);
        tv_frag_home_recent_lecture_review_3_content = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_3_content);

        iv_frag_home_recent_lecture_review_4_rank = viewGroup.findViewById(R.id.iv_frag_home_recent_lecture_review_4_rank);
        tv_frag_home_recent_lecture_review_4_subject = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_4_subject);
        tv_frag_home_recent_lecture_review_4_professor = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_4_professor);
        tv_frag_home_recent_lecture_review_4_content = viewGroup.findViewById(R.id.tv_frag_home_recent_lecture_review_4_content);
    }

    @Override
    public void realTimeHotPostSuccess(RealTimeHotPostResponse realTimeHotPostResponse) {
        switch (realTimeHotPostResponse.getCode()) {
            case 100:
                tv_frag_home_realtime_hot_post_1_user_name.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentWriter());
                tv_frag_home_realtime_hot_post_1_date.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getWriteDay());
                tv_frag_home_realtime_hot_post_1_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentTitle());
                tv_frag_home_realtime_hot_post_1_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getContentInf());
                tv_frag_home_realtime_hot_post_1_board_type.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getNoticeName());
                tv_frag_home_realtime_hot_post_1_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountLike());
                tv_frag_home_realtime_hot_post_1_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(0).getCountComment());

                tv_frag_home_realtime_hot_post_2_user_name.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentWriter());
                tv_frag_home_realtime_hot_post_2_date.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getWriteDay());
                tv_frag_home_realtime_hot_post_2_title.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentTitle());
                tv_frag_home_realtime_hot_post_2_content.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getContentInf());
                tv_frag_home_realtime_hot_post_2_board_type.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getNoticeName());
                tv_frag_home_realtime_hot_post_2_like_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountLike());
                tv_frag_home_realtime_hot_post_2_comment_num.setText(realTimeHotPostResponse.getRealTimeHotPostResults().get(1).getCountComment());
                break;
        }
    }

    @Override
    public void hotPostSuccess(HotPostResponse hotPostResponse) {
        switch (hotPostResponse.getCode()) {

            case 100:
                int num_of_hot_posts = hotPostResponse.getHotPostResults().size();

                switch (num_of_hot_posts) {
                    case 0:
                        break;
                    case 1:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());
                        break;
                    case 2:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());
                        break;
                    case 3:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());

                        tv_frag_home_hot_post_3_title.setText(hotPostResponse.getHotPostResults().get(2).getContentTitle());
                        tv_frag_home_hot_post_3_time.setText(hotPostResponse.getHotPostResults().get(2).getWriteDay());
                        tv_frag_home_hot_post_3_like_num.setText(hotPostResponse.getHotPostResults().get(2).getCountLike());
                        tv_frag_home_hot_post_3_comment_num.setText(hotPostResponse.getHotPostResults().get(2).getCountComment());
                    default:
                        tv_frag_home_hot_post_1_title.setText(hotPostResponse.getHotPostResults().get(0).getContentTitle());
                        tv_frag_home_hot_post_1_time.setText(hotPostResponse.getHotPostResults().get(0).getWriteDay());
                        tv_frag_home_hot_post_1_like_num.setText(hotPostResponse.getHotPostResults().get(0).getCountLike());
                        tv_frag_home_hot_post_1_comment_num.setText(hotPostResponse.getHotPostResults().get(0).getCountComment());

                        tv_frag_home_hot_post_2_title.setText(hotPostResponse.getHotPostResults().get(1).getContentTitle());
                        tv_frag_home_hot_post_2_time.setText(hotPostResponse.getHotPostResults().get(1).getWriteDay());
                        tv_frag_home_hot_post_2_like_num.setText(hotPostResponse.getHotPostResults().get(1).getCountLike());
                        tv_frag_home_hot_post_2_comment_num.setText(hotPostResponse.getHotPostResults().get(1).getCountComment());

                        tv_frag_home_hot_post_3_title.setText(hotPostResponse.getHotPostResults().get(2).getContentTitle());
                        tv_frag_home_hot_post_3_time.setText(hotPostResponse.getHotPostResults().get(2).getWriteDay());
                        tv_frag_home_hot_post_3_like_num.setText(hotPostResponse.getHotPostResults().get(2).getCountLike());
                        tv_frag_home_hot_post_3_comment_num.setText(hotPostResponse.getHotPostResults().get(2).getCountComment());

                        tv_frag_home_hot_post_4_title.setText(hotPostResponse.getHotPostResults().get(3).getContentTitle());
                        tv_frag_home_hot_post_4_time.setText(hotPostResponse.getHotPostResults().get(3).getWriteDay());
                        tv_frag_home_hot_post_4_like_num.setText(hotPostResponse.getHotPostResults().get(3).getCountLike());
                        tv_frag_home_hot_post_4_comment_num.setText(hotPostResponse.getHotPostResults().get(3).getCountComment());
                        break;
                }
        }
    }

    @Override
    public void recentLectureReviewSuccess(RecentLectureReviewResponse recentLectureReviewResponse) {
        switch (recentLectureReviewResponse.getCode()) {
            case 100:
                int num_of_recent_lecture_reviews = recentLectureReviewResponse.getRecentLectureReviewResults().size();

                int int_rate_1 = 0;
                int int_rate_2 = 0;
                int int_rate_3 = 0;
                int int_rate_4 = 0;

                switch (num_of_recent_lecture_reviews) {

                    case 0:
                        break;
                    case 1:
                        int_rate_1 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(0));
                        switch (int_rate_1) {
                            case 1:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_1_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassName());
                        tv_frag_home_recent_lecture_review_1_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getProfessor());
                        tv_frag_home_recent_lecture_review_1_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassCommentInf());
                        break;
                    case 2:
                        int_rate_1 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(0));
                        int_rate_2 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(1));
                        switch (int_rate_1) {
                            case 1:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_1_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassName());
                        tv_frag_home_recent_lecture_review_1_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getProfessor());
                        tv_frag_home_recent_lecture_review_1_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassCommentInf());

                        switch (int_rate_2) {
                            case 1:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_2_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassName());
                        tv_frag_home_recent_lecture_review_2_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getProfessor());
                        tv_frag_home_recent_lecture_review_2_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassCommentInf());
                        break;

                    case 3:
                        int_rate_1 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(0));
                        int_rate_2 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(1));
                        int_rate_3 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(2));

                        switch (int_rate_1) {
                            case 1:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_1_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassName());
                        tv_frag_home_recent_lecture_review_1_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getProfessor());
                        tv_frag_home_recent_lecture_review_1_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassCommentInf());

                        switch (int_rate_2) {
                            case 1:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_2_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassName());
                        tv_frag_home_recent_lecture_review_2_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getProfessor());
                        tv_frag_home_recent_lecture_review_2_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassCommentInf());

                        switch (int_rate_3) {
                            case 1:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_3_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getClassName());
                        tv_frag_home_recent_lecture_review_3_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getProfessor());
                        tv_frag_home_recent_lecture_review_3_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getClassCommentInf());
                        break;
                    default:
                        int_rate_1 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(0));
                        int_rate_2 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(1));
                        int_rate_3 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(2));
                        int_rate_4 = convertDoubleRateToDiscreteInt(recentLectureReviewResponse.getRecentLectureReviewResults().get(3));

                        switch (int_rate_1) {
                            case 1:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_1_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_1_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassName());
                        tv_frag_home_recent_lecture_review_1_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getProfessor());
                        tv_frag_home_recent_lecture_review_1_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(0).getClassCommentInf());

                        switch (int_rate_2) {
                            case 1:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_2_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_2_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassName());
                        tv_frag_home_recent_lecture_review_2_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getProfessor());
                        tv_frag_home_recent_lecture_review_2_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(1).getClassCommentInf());

                        switch (int_rate_3) {
                            case 1:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_3_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_3_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getClassName());
                        tv_frag_home_recent_lecture_review_3_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getProfessor());
                        tv_frag_home_recent_lecture_review_3_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(2).getClassCommentInf());

                        switch (int_rate_4) {
                            case 1:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_0_half);
                                break;
                            case 2:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_1);
                                break;
                            case 3:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_1_half);
                                break;
                            case 4:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_2);
                                break;
                            case 5:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_2_half);
                                break;
                            case 6:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_3);
                                break;
                            case 7:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_3_half);
                                break;
                            case 8:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_4);
                                break;
                            case 9:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_4_half);
                                break;
                            case 10:
                                iv_frag_home_recent_lecture_review_4_rank.setImageResource(R.drawable.star_rate_5);
                                break;
                        }
                        tv_frag_home_recent_lecture_review_4_subject.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(3).getClassName());
                        tv_frag_home_recent_lecture_review_4_professor.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(3).getProfessor());
                        tv_frag_home_recent_lecture_review_4_content.setText(recentLectureReviewResponse.getRecentLectureReviewResults().get(3).getClassCommentInf());
                        break;
                }


        }


    }

    @Override
    public void getFreeBoardSuccess(CommonBoardResponse commonBoardResponse) {
        tv_frag_home_favorite_free_board_first_post.setText(commonBoardResponse.getCommonBoardResults().get(0).getContentTitle());
    }

    @Override
    public void getSecretBoardSuccess(CommonBoardResponse commonBoardResponse) {
        tv_frag_home_favorite_secret_board_first_post.setText(commonBoardResponse.getCommonBoardResults().get(0).getContentTitle());
    }

    @Override
    public void getAlumniBoardSuccess(CommonBoardResponse commonBoardResponse) {
        tv_frag_home_favorite_alumni_board_first_post.setText(commonBoardResponse.getCommonBoardResults().get(0).getContentTitle());
    }

    @Override
    public void getFreshmenBoardSuccess(CommonBoardResponse commonBoardResponse) {
        tv_frag_home_favorite_freshmen_board_first_post.setText(commonBoardResponse.getCommonBoardResults().get(0).getContentTitle());
    }

    public void linkIconsToWebSites() {
        /**
         * frag_home 상단의 6개 아이콘에 링크 걸어주기
         * */
        linear_layout_frag_home_univ_homepage = viewGroup.findViewById(R.id.linear_layout_frag_home_univ_homepage);
        linear_layout_frag_home_univ_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mportal.ajou.ac.kr/main.do"));
                startActivity(intent);
            }
        });

        linear_layout_frag_home_shuttle_bus = viewGroup.findViewById(R.id.linear_layout_frag_home_shuttle_bus);
        linear_layout_frag_home_shuttle_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ajou.ac.kr/main/life/bus01.jsp"));
                startActivity(intent);
            }
        });

        linear_layout_frag_home_notificaition = viewGroup.findViewById(R.id.linear_layout_frag_home_notificaition);
        linear_layout_frag_home_notificaition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ajou.ac.kr/main/ajou/notice.jsp"));
                startActivity(intent);
            }
        });

        linear_layout_frag_home_schedule = viewGroup.findViewById(R.id.linear_layout_frag_home_schedule);
        linear_layout_frag_home_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ajou.ac.kr/main/life/schedule_haksa.jsp"));
                startActivity(intent);
            }
        });

        linear_layout_frag_home_library = viewGroup.findViewById(R.id.linear_layout_frag_home_library);
        linear_layout_frag_home_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://library.ajou.ac.kr/#/"));
                startActivity(intent);
            }
        });

        linear_layout_frag_home_web_mail = viewGroup.findViewById(R.id.linear_layout_frag_home_web_mail);
        linear_layout_frag_home_web_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ajou.ac.kr/main/index.jsp"));
                startActivity(intent);
            }
        });
    }

    public void viewBindLinearLayout() {
        /**
         * 클릭하는 게시물에 따라서, 무엇을 클릭하였는지를 같이 putExtra로 넘겨준다!!
         * */
        linear_layout_frag_home_realtime_hot_post_1 = viewGroup.findViewById(R.id.linear_layout_frag_home_realtime_hot_post_1);
        linear_layout_frag_home_realtime_hot_post_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "realtime_hot_post_1");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_realtime_hot_post_2 = viewGroup.findViewById(R.id.linear_layout_frag_home_realtime_hot_post_2);
        linear_layout_frag_home_realtime_hot_post_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "realtime_hot_post_2");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_hot_post_1 = viewGroup.findViewById(R.id.linear_layout_frag_home_hot_post_1);
        linear_layout_frag_home_hot_post_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "hot_post_1");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_hot_post_2 = viewGroup.findViewById(R.id.linear_layout_frag_home_hot_post_2);
        linear_layout_frag_home_hot_post_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "hot_post_2");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_hot_post_3 = viewGroup.findViewById(R.id.linear_layout_frag_home_hot_post_3);
        linear_layout_frag_home_hot_post_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "hot_post_3");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_hot_post_4 = viewGroup.findViewById(R.id.linear_layout_frag_home_hot_post_4);
        linear_layout_frag_home_hot_post_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InPostActivity.class);
                intent.putExtra("clicked", "hot_post_4");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_recent_lecture_review_1 = viewGroup.findViewById(R.id.linear_layout_frag_home_recent_lecture_review_1);
        linear_layout_frag_home_recent_lecture_review_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LectureReviewInSubjectActivity.class);
                intent.putExtra("clicked", "review_1");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_recent_lecture_review_2 = viewGroup.findViewById(R.id.linear_layout_frag_home_recent_lecture_review_2);
        linear_layout_frag_home_recent_lecture_review_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LectureReviewInSubjectActivity.class);
                intent.putExtra("clicked", "review_2");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_recent_lecture_review_3 = viewGroup.findViewById(R.id.linear_layout_frag_home_recent_lecture_review_3);
        linear_layout_frag_home_recent_lecture_review_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LectureReviewInSubjectActivity.class);
                intent.putExtra("clicked", "review_3");
                startActivity(intent);
            }
        });

        linear_layout_frag_home_recent_lecture_review_4 = viewGroup.findViewById(R.id.linear_layout_frag_home_recent_lecture_review_4);
        linear_layout_frag_home_recent_lecture_review_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LectureReviewInSubjectActivity.class);
                intent.putExtra("clicked", "review_4");
                startActivity(intent);
            }
        });
    }
}
