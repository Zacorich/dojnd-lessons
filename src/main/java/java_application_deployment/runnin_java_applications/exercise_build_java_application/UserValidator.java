package java_application_deployment.runnin_java_applications.exercise_build_java_application;

public class UserValidator {

	private ValidationStrategy strategy;

	public boolean validateUser(User user) {
		if (strategy != null) {
			return strategy.validateUser(user);
		}

		return true;
	}

	public void setValidationStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

}
