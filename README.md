# play-spotbugs-test

A Play application with spotbugs issues.

This application was developed to serve as a test-case for the usage of [SpotBugs](https://spotbugs.github.io/) with [Codacy](https://www.codacy.com), 
implemented through the [codacy-spotbugs integration](https://github.com/codacy/codacy-spotbugs) together with the [Codacy CLI](https://github.com/codacy/codacy-analysis-cli).

## Running the test

- Requirements:
  - Installed the [Codacy CLI](https://github.com/codacy/codacy-analysis-cli) (the latest version)
  - This application (`play-spotbugs-test`) is compiled 
  
- Running:

```
codacy-analysis-cli analyse --tool spotbugs --directory </PATH/to/TEST/application> --allow-network true
```

- Ouput:

The `codacy-analysis-cli` should output the following issues:
```
Found [Error] `This use of slick/jdbc/SQLActionBuilder.<init>(Lscala/collection/Seq;Lslick/jdbc/SetParameter;)V can be vulnerable to SQL injection (with Slick)` in app/models/Thing.scala:39 (SCALA_SQL_INJECTION_SLICK)
Found [Error] `This Scala random generator (scala.util.Random) is predictable` in app/controllers/HomeController.scala:36 (PREDICTABLE_RANDOM_SCALA)
```

## Scala versions

Cross-building to Scala 2.11 and 2.12 is supported.


## What is Codacy

[Codacy](https://www.codacy.com/) is an Automated Code Review Tool that monitors your technical debt, helps you improve your code quality, teaches best practices to your developers, and helps you save time in Code Reviews.

### Among Codacy’s features

- Identify new Static Analysis issues
- Commit and Pull Request Analysis with GitHub, BitBucket, GitLab (and also direct git repositories)
- Auto-comments on Commits and Pull Requests
- Integrations with Slack, Jira
- Track issues in Code Style, Security, Error Proneness, Performance, Unused Code and other categories

Codacy also helps keep track of Code coverage, Code duplication, and Code complexity.

Codacy supports PHP, Python, Ruby, Java, JavaScript, and Scala, among others.

### Free for Open Source

Codacy is free for Open Source projects.
