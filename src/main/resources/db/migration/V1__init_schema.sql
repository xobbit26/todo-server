DROP TABLE IF EXISTS todo_item cascade;

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
CREATE TABLE todo_item
(
    id BIGINT NOT NULL,
    text VARCHAR(1000) NOT NULL,
    created_on TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_on TIMESTAMP WITHOUT TIME ZONE,
    is_completed BOOLEAN NOT NULL,
    completed_on TIMESTAMP WITHOUT TIME ZONE
);

ALTER TABLE todo_item ADD PRIMARY KEY (id);