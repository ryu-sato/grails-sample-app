databaseChangeLog = {

    changeSet(author: "tatsurou (generated)", id: "1537117937663-1") {
        createTable(tableName: "EMPLOYEE") {
            column(autoIncrement: "true", name: "ID", type: "BIGINT(19)") {
                constraints(primaryKey: "true", primaryKeyName: "CONSTRAINT_7")
            }

            column(name: "VERSION", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }

            column(name: "DEPARTMENT", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "JOINED_DATE", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "BIRTH", type: "TIMESTAMP") {
                constraints(nullable: "false")
            }

            column(name: "NAME", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "GENDER", type: "VARCHAR(6)") {
                constraints(nullable: "false")
            }

            column(name: "NOTE", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "PAYMENT", type: "BIGINT(19)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "tatsurou (generated)", id: "1537117937663-2") {
        addUniqueConstraint(columnNames: "NAME", constraintName: "UK_HAFQWJQE2E9BCPGYJ6EVM52AP", tableName: "EMPLOYEE")
    }
}
