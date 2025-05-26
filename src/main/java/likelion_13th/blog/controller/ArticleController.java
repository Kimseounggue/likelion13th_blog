package likelion_13th.blog.controller;

import likelion_13th.blog.dto.reponse.ApiResponse;
import likelion_13th.blog.dto.reponse.ArticleDetailResponse;
import likelion_13th.blog.dto.reponse.ArticleResponse;
import likelion_13th.blog.dto.reponse.SimpleArticleResponse;
import likelion_13th.blog.dto.request.UpdateArticleRequest;
import likelion_13th.blog.dto.request.AddArticleRequest;
import likelion_13th.blog.dto.request.DeleteRequest;
import likelion_13th.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleService articleService;

    /*게시글 추가*/
    @PostMapping
    public ResponseEntity<ApiResponse> createArticle(@RequestBody AddArticleRequest request){
        ArticleResponse response=articleService.addArticle(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true,201,"게시글 등록 성공",response));
    }

    /*게시글 전체 조회*/
    @GetMapping
    public ResponseEntity<ApiResponse> ReadAllArticles(){

        List<SimpleArticleResponse> articles=articleService.getAllArticles();
        return ResponseEntity.ok(new ApiResponse(true, 200, "게시글 조회 성공", articles));

    }


    /*게시글 단일 조회*/
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> ReadArticle(@PathVariable long id){
        ArticleDetailResponse response=articleService.getArticle(id);
        return ResponseEntity.ok(new ApiResponse(true,200,"게시글 조회 성공", response));

    }



    /*게시글 수정*/
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArticle(@PathVariable long id,
                                                     @RequestBody UpdateArticleRequest request){
        articleService.updateArticle(id,request);
        return ResponseEntity.ok(new ApiResponse(true,204,"게시글 수정 성공"));

    }

    /*게시글 삭제*/
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArticle(@PathVariable long id,
                                                     @RequestBody DeleteRequest request){
        articleService.deleteArticle(id,request);
        return ResponseEntity.ok(new ApiResponse(true,204,"게시글 삭제 성공"));

    }
}