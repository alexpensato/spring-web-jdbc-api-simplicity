/*
 * Copyright 2017-2020 Alex Magalhaes <alex@pensatocode.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pensatocode.simplicity.jdbc.sql

import org.pensatocode.simplicity.jdbc.TableDescription
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

import java.sql.DatabaseMetaData
import java.sql.SQLException

interface SqlGenerator {

    /**
     * This method is used by [SqlGeneratorFactory] to select a right SQL Generator.
     *
     * @param metadata The database metadata.
     * @return Whether is this generator compatible with the database described by the given `metadata`.
     */
    @Throws(SQLException::class)
    fun isCompatible(metadata: DatabaseMetaData): Boolean

    fun count(table: TableDescription): String

    fun deleteAll(table: TableDescription): String

    fun deleteByPK(table: TableDescription): String

    fun existsByPK(table: TableDescription): String

    fun insert(table: TableDescription, autoGeneratedKey: Boolean): String

    fun selectAll(table: TableDescription): String

    fun selectAll(table: TableDescription, whereClause: String): String

    fun selectAll(table: TableDescription, page: Pageable): String

    fun selectAll(table: TableDescription, whereClause: String, page: Pageable): String

    fun selectAll(table: TableDescription, sort: Sort): String

    fun selectAll(table: TableDescription, whereClause: String, sort: Sort): String

    fun selectByPK(table: TableDescription): String

    fun update(table: TableDescription): String
}
