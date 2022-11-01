package jp.co.IssueTrackingSystem.PracticeForWebApp.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.IssueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IssueController {

    private final IssueService issueService = new IssueService();

    @GetMapping("/issues")
    public String showList(Model model){

        model.addAttribute("issueList", issueService.findAllIssues());
        return "issues/list";
    }
}
