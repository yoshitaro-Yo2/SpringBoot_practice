package jp.co.IssueTrackingSystem.PracticeForWebApp.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.IssueEntity;
import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String Create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }

    @GetMapping("/{issueId}")
    // @ModelAttribute で model.addAttribute("issueForm", new IssueForm()); と同じ処理になる
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        IssueEntity dummyEntity = new IssueEntity(1, "概要", "説明");
        model.addAttribute("issue", dummyEntity);
        return "issues/detail";
    }

}
