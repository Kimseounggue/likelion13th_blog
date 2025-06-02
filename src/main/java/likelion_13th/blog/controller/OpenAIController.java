package likelion_13th.blog.controller;


import likelion_13th.blog.dto.reponse.ChatResponse;
import likelion_13th.blog.dto.request.ChatRequest;
import likelion_13th.blog.service.OpenAIChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class OpenAIController {
    private final OpenAIChatService openAiChatService;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request){
        String response=openAiChatService.getChatResponse(request);
        return ResponseEntity.ok(new ChatResponse(response));
    }

}
