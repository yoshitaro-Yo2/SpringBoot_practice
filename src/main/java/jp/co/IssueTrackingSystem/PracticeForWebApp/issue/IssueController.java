package jp.co.IssueTrackingSystem.PracticeForWebApp.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping
    public String showList(Model model){

        model.addAttribute("issueList", issueService.findAllIssues());
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(){
        return "issues/creationForm";
    }

    @PostMapping
    public String Create(IssueForm form, Model model){
        // TODO データの永続化
        return showList(model); // TODO リロードボタン対策必須
    }
}
