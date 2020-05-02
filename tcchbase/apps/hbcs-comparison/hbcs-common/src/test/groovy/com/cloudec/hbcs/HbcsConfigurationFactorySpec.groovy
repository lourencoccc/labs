package com.cloudec.hbcs

import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
class HbcsConfigurationFactorySpec extends Specification {

  def "should convert complex object"() {
    setup:
    Yaml yaml = new Yaml();
    def document = """
    nameSpace: &space ia
    tables:
      - name: posts
        nameSpace: *space
        sourceFile: Posts.xml
        keyField: Id
        cfName: post
        rowKeys:
          - PostHistoryTypeId
          - PostId
          - Id
        columns:
          - PostHistoryTypeId
          - PostId
          - Id
        cassandraColumnTypes:
          CreationDate: timestamp
          Score: int
          ViewCount: int
          LastEditDate: timestamp
          LastActivityDate: timestamp
          CommunityOwnedDate: timestamp
          ClosedDate: timestamp
          AnswerCount: int
          CommentCount: int
          FavoriteCount: int
        aggregates:
          - name: posthistory
            sourceFile: PostHistory.xml
            keyField: Id
            cfName: posthistory
            refKeyField: PostId
    """

    when:
    HbcsConfiguration config = HbcsConfigurationFactory.create(document)
    then:
    config.nameSpace == 'ia'
    and:
    config.tables[0].tableName(HbcsTypeDatabase.HBASE) == 'ia:posts'
    and:
    config.tables[0].sourceFile == 'Posts.xml'
    and:
    config.tables[0].aggregates[0].name == 'posthistory'
    and:
    config.tables[0].aggregates[0].keyField == 'Id'
    and:
    config.tables[0].aggregates[0].refKeyField == 'PostId'
    and:
    config.tables[0].cassandraColumnTypes['Id'] == null
    and:
    config.tables[0].columnType('Id') == 'text'
    and:
    config.tables[0].cassandraColumnTypes['LastEditDate'] == 'timestamp'
    and:
    config.tables[0].columnSet().containsAll(['PostHistoryTypeId', 'PostId', 'Id'])
  }
}
