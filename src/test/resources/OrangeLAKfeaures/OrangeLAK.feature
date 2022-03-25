Feature: Orange Login Test

  @tag1
  Scenario: User tries to login with invalid credintials
    Given User launches application
    When User enters invalid credintials
    Then User clicks login

  @tag2
  Scenario: User resets password
    Given User clicks on forgot password
    When User resets password with invalid useranme
    And User resets password with valid username
    Then User clicks on cancel

  @tag3
  Scenario: User	tries to login
    When User clicks login button without usernmae
    And User clicks login button without password
    Then User clicks login with valid username and password
