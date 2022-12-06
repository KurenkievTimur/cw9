CREATE TABLE IF NOT EXISTS "user"
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    name     VARCHAR(25)           NOT NULL,
    email    VARCHAR(25)           NOT NULL,
    username VARCHAR(25)           NOT NULL,
    password CHARACTER VARYING     NOT NULL,
    locked   BOOLEAN DEFAULT FALSE NOT NULL,
    enabled  BOOLEAN DEFAULT TRUE  NOT NULL
);

CREATE TABLE IF NOT EXISTS "role"
(
    id   BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(25)           NOT NULL
);

CREATE TABLE IF NOT EXISTS "permission"
(
    id   BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(25)           NOT NULL
);

CREATE TABLE IF NOT EXISTS "user_role"
(
    user_id BIGINT REFERENCES "user" (id) NOT NULL,
    role_id BIGINT REFERENCES "role" (id) NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS "role_permission"
(
    role_id       BIGINT REFERENCES "role" (id)       NOT NULL,
    permission_id BIGINT REFERENCES "permission" (id) NOT NULL,
    PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE IF NOT EXISTS "task"
(
    id         BIGSERIAL PRIMARY KEY         NOT NULL,
    created_at TIMESTAMP DEFAULT now()       NOT NULL,
    name       VARCHAR(20)                   NOT NULL,
    status     VARCHAR(20)                   NOT NULL,
    user_id    BIGINT REFERENCES "user" (id) NOT NULL
);

CREATE TABLE IF NOT EXISTS "work_log"
(
    id         BIGSERIAL PRIMARY KEY         NOT NULL,
    created_at TIMESTAMP DEFAULT now()       NOT NULL,
    time       VARCHAR(6)                    NOT NULL,
    task_id    BIGINT REFERENCES "task" (id) NOT NULL
);

CREATE TABLE IF NOT EXISTS "attachment"
(
    id      BIGSERIAL PRIMARY KEY         NOT NULL,
    name    CHARACTER VARYING             NOT NULL,
    task_id BIGINT REFERENCES "task" (id) NOT NULL
);