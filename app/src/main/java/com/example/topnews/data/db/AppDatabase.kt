package com.example.topnews.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.topnews.data.model.Article
import com.example.topnews.data.model.SourceRaw
import com.example.topnews.data.model.Tag
import com.example.topnews.data.model.TagArticle
import java.util.concurrent.Executors

@Database(
	entities = [Article::class, SourceRaw::class, Tag::class, TagArticle::class], version = 1, exportSchema =
	true
)
abstract class AppDatabase : RoomDatabase() {

	abstract fun articlesDao(): ArticleDao
	abstract fun tagsDao(): TagsDao
	abstract fun tagArticleDao(): TagArticleDao

	companion object {

		private  var INSTANCE: AppDatabase? = null

		@Synchronized
		fun getInstance(context: Context): AppDatabase {
			if (INSTANCE == null) {
				INSTANCE = buildDatabase(context)
			}
			return INSTANCE!!
		}

		fun buildDatabase(context: Context): AppDatabase {
			return Room
				.databaseBuilder(context, AppDatabase::class.java, "article-db")
				.addCallback(object : Callback() {
					override fun onCreate(db: SupportSQLiteDatabase) {
						super.onCreate(db);
						Executors.newSingleThreadScheduledExecutor().execute {
							getInstance(context).tagsDao().addTags(
								listOf(
									Tag("tag1"),
									Tag("tag2"),
									Tag("tag3"),
									Tag("tag4"),
									Tag("tag5")
								)
							)
							getInstance(context).articlesDao()
						}
					}
				})
				.build()

		}
	}

}