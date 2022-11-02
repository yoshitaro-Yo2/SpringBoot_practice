package jp.co.IssueTrackingSystem.PracticeForWebApp.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    // @ModelAttribute で model.addAttribute("issueForm", new IssueForm()); と同じ処理になる
    public String showCreationForm(@ModelAttribute IssueForm issueForm) {
        return "issues/creationForm";
    }

    @PostMapping
    public String Create(IssueForm form, Model model){
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }
}
