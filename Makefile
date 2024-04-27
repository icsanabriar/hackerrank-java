export OUTPUT_PATH=$(shell pwd)/target/test-output.out

.PHONY: help
.DEFAULT_GOAL := help
help: ## Show this help.
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: unit-test
unit-test: ## Execute the unit tests of the different modules of the project.
	mvn clean test

.PHONY: coverage
coverage: ## Execute the commands to generate coverage report.
	mvn clean verify
	open target/site/jacoco/index.html

.PHONY: licenses
licenses: ## Execute the commands to generate license report.
	mvn project-info-reports:dependencies
	open target/site/dependencies.html

.PHONY: clean
clean: ## Remove the executable modules of the project.
	mvn clean