package com.cymbocha.apis.testrail;

import com.cymbocha.apis.testrail.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author kms
 */
@AllArgsConstructor
public class TestRail {

    private final TestRailConfig config;

    public Projects projects() {
        return new Projects();
    }

    public CaseFields caseFields() {
        return new CaseFields();
    }

    public CaseTypes caseTypes() {
        return new CaseTypes();
    }

    public Configurations configurations() {
        return new Configurations();
    }

    public Sections sections() {
        return new Sections();
    }

    public Suites suites() {
        return new Suites();
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class Projects {

        public Get get(@NonNull Project project) {
            return new Get(project);
        }

        public List list() {
            return new List();
        }

        public Add add(@NonNull Project project) {
            return new Add(project);
        }

        public Update update(@NonNull Project project) {
            return new Update(project);
        }

        public Delete delete(@NonNull Project project) {
            return new Delete(project);
        }

        public class Get extends Request<Project> {
            private static final String REST_PATH = "get_project/";

            private Get(@NonNull Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), Project.class);
            }
        }

        public class List extends Request<java.util.List<Project>> {
            private static final String REST_PATH = "get_projects";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<Project>>() {
                });
            }
        }

        public class Add extends Request<Project> {
            private static final String REST_PATH = "add_project";

            private final Project project;

            private Add(@NonNull Project project) {
                super(config, Method.POST, REST_PATH, Project.class);
                this.project = project;
            }

            @Override
            protected Object getContent() {
                return project;
            }

        }

        public class Update extends Request<Project> {
            private static final String REST_PATH = "update_project/";

            private final Project project;

            private Update(@NonNull Project project) {
                super(config, Method.POST, REST_PATH + project.getId(), Project.class);
                this.project = project;
            }

            @Override
            protected Object getContent() {
                return project;
            }

        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_project/";

            private final Project project;

            private Delete(@NonNull Project project) {
                super(config, Method.POST, REST_PATH + project.getId(), Void.class);
                this.project = project;
            }

        }
    }

    @NoArgsConstructor
    public class CaseFields {

        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<CaseField>> {
            private static final String REST_PATH = "get_case_fields";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<CaseField>>() {
                });
            }
        }
    }

    @NoArgsConstructor
    public class CaseTypes {

        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<CaseType>> {
            private static final String REST_PATH = "get_case_types";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<CaseType>>() {
                });
            }
        }

    }

    @NoArgsConstructor
    public class Configurations {

        public List list(@NonNull Project project) {
            return new List(project);
        }

        public class List extends Request<java.util.List<Configuration>> {
            private static final String REST_PATH = "get_configs/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Configuration>>() {
                });
            }

        }

    }

    @NoArgsConstructor
    public class Sections {

        public Get get(@NonNull Section section) {
            return new Get(section);
        }

        public List list(@NonNull Project project, Suite suite) {
            return new List(project, suite);
        }

        public Add add(@NonNull Project project, @NonNull Section section) {
            return new Add(project, section);
        }

        public Update update(@NonNull Section section) {
            return new Update(section);
        }

        public Delete delete(@NonNull Section section) {
            return new Delete(section);
        }

        public class Get extends Request<Section> {
            private static final String REST_PATH = "get_section/";

            private Get(Section section) {
                super(config, Method.GET, REST_PATH + section.getId(), Section.class);
            }

        }

        public class List extends Request<java.util.List<Section>> {
            private static final String REST_PATH = "get_sections/%s&suite_id=%s";

            private List(Project project, Suite suite) {
                super(config, Method.GET, String.format(REST_PATH, project.getId(), suite.getId()), new TypeReference<java.util.List<Section>>() {
                });
            }
        }

        public class Add extends Request<Section> {
            private static final String REST_PATH = "add_section/";

            private final Section section;

            private Add(Project project, Section section) {
                super(config, Method.POST, REST_PATH + project.getId(), Section.class);
                this.section = section;
            }

            @Override
            protected Object getContent() {
                return section;
            }
        }

        public class Update extends Request<Section> {
            private static final String REST_PATH = "update_section/";

            private final Section section;

            private Update(Section section) {
                super(config, Method.POST, REST_PATH + section.getId(), Section.class);
                this.section = section;
            }

            @Override
            protected Object getContent() {
                return section;
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_section/";

            private Delete(Section section) {
                super(config, Method.POST, REST_PATH + section.getId(), Void.class);
            }
        }
    }

    @NoArgsConstructor
    public class Suites {

        public Get get(@NonNull Suite suite) {
            return new Get(suite);
        }

        public List list(@NonNull Project project) {
            return new List(project);
        }

        public Add add(@NonNull Suite suite) {
            return new Add(suite);
        }

        public Update update(@NonNull Suite suite) {
            return new Update(suite);
        }

        public Delete delete(@NonNull Suite suite) {
            return new Delete(suite);
        }

        public class Get extends Request<Suite> {
            private static final String REST_PATH = "get_suite/";

            private Get(Suite suite) {
                super(config, Method.GET, REST_PATH + suite.getId(), Suite.class);
            }
        }

        public class List extends Request<java.util.List<Suite>> {
            private static final String REST_PATH = "get_suites/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Suite>>() {
                });
            }
        }

        public class Add extends Request<Suite> {
            private static final String REST_PATH = "add_suite/";

            private final Suite suite;

            private Add(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getProjectId(), Suite.class);
                this.suite = suite;
            }

            @Override
            protected Object getContent() {
                return suite;
            }
        }

        public class Update extends Request<Suite> {
            private static final String REST_PATH = "update_suite/";

            private final Suite suite;

            private Update(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getId(), Suite.class);
                this.suite = suite;
            }

            @Override
            protected Object getContent() {
                return suite;
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_suite/";

            private Delete(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getId(), Void.class);
            }
        }

    }
}