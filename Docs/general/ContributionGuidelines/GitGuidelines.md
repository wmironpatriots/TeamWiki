# Git Guidelines
This guide assumes that you have good beginners knowledge of Git.

## Branches
* Names should be short and descriptive
* Words in names should be seperated with hyphens
```
# Good name; simple but descriptive, follows guidelines
git checkout -b source-align

# Bad name; Too much info & doesn't follow guidelines
git checkout -b sourceDriveAlignmentCmd

# Terrible name; Quit the team atp
git checkout -b bajablastYeehaw
```
---
* When multiple people are working on a feature, create personal branches for each member working on feature
```
# Main feature branch; This is what will eventually be merged to master
git checkout -b fast-odometry/main

# Personal branches
git checkout -b fast-odometry/dabeycorn
git checkout -b fast-odometry/kiri
git checkout -b fast-odometry/ditty_bop_
```
* These personal branches will eventually merged into the main branch of the feature, which will then be ready to merge into master
---
* **Remember**, once a branch has been merged, it should be removed from the upstream repository

## Commits
* Each commit is a single logical change. For example, the creation of bug fix and the addition of a new command should be seperated into two different commits. **Remember, only 1 logical change per commit**
* Commit often. Make it easier to revert when something goes wrong without loosing too much
* Commits should be ordered logically. You add pizza toppings after you flatten the dough, not the other way around.
### Messages
A commit message should summarize your change in 50 characters or less.
```
Short (50 chars or fewer) summary of changes

More detailed explanatory text, if necessary. Wrap it to
72 characters. In some contexts, the first
line is treated as the subject of an email and the rest of
the text as the body.  The blank line separating the
summary from the body is critical (unless you omit the body
entirely); tools like rebase can get confused if you run
the two together.

Further paragraphs come after blank lines.

- Bullet points are okay, too

- Use a hyphen or an asterisk for the bullet,
  followed by a single space, with blank lines in
  between

The pointers to your related resources can serve as a footer
for your commit message. Here is an example that is referencing
issues in a bug tracker:

Resolves: #56, #78
See also: #12, #34

Source: http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html
```

* Before you finish a commit, look at it and think about what you would want to know about it in another year
* **Finally**, make sure you signoff your commit. When you signoff a commit you acknowledge that you wrote this commit
```
git commit -m "Fix
```

TODO add squash docs 