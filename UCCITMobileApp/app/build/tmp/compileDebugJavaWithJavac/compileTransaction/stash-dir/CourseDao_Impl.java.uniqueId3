package com.ucc.itmobileapp.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ucc.itmobileapp.models.Course;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CourseDao_Impl implements CourseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Course> __insertionAdapterOfCourse;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CourseDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCourse = new EntityInsertionAdapter<Course>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `courses` (`code`,`name`,`credits`,`prerequisites`,`description`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Course entity) {
        if (entity.getCode() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getCode());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getCredits());
        if (entity.getPrerequisites() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPrerequisites());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM courses";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<Course> courses) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCourse.insert(courses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Course course) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCourse.insert(course);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Course> getAllCourses() {
    final String _sql = "SELECT * FROM courses ORDER BY code ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCredits = CursorUtil.getColumnIndexOrThrow(_cursor, "credits");
      final int _cursorIndexOfPrerequisites = CursorUtil.getColumnIndexOrThrow(_cursor, "prerequisites");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final List<Course> _result = new ArrayList<Course>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Course _item;
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpCredits;
        _tmpCredits = _cursor.getInt(_cursorIndexOfCredits);
        final String _tmpPrerequisites;
        if (_cursor.isNull(_cursorIndexOfPrerequisites)) {
          _tmpPrerequisites = null;
        } else {
          _tmpPrerequisites = _cursor.getString(_cursorIndexOfPrerequisites);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _item = new Course(_tmpCode,_tmpName,_tmpCredits,_tmpPrerequisites,_tmpDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Course getCourseByCode(final String courseCode) {
    final String _sql = "SELECT * FROM courses WHERE code = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (courseCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, courseCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCredits = CursorUtil.getColumnIndexOrThrow(_cursor, "credits");
      final int _cursorIndexOfPrerequisites = CursorUtil.getColumnIndexOrThrow(_cursor, "prerequisites");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final Course _result;
      if (_cursor.moveToFirst()) {
        final String _tmpCode;
        if (_cursor.isNull(_cursorIndexOfCode)) {
          _tmpCode = null;
        } else {
          _tmpCode = _cursor.getString(_cursorIndexOfCode);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final int _tmpCredits;
        _tmpCredits = _cursor.getInt(_cursorIndexOfCredits);
        final String _tmpPrerequisites;
        if (_cursor.isNull(_cursorIndexOfPrerequisites)) {
          _tmpPrerequisites = null;
        } else {
          _tmpPrerequisites = _cursor.getString(_cursorIndexOfPrerequisites);
        }
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        _result = new Course(_tmpCode,_tmpName,_tmpCredits,_tmpPrerequisites,_tmpDescription);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCount() {
    final String _sql = "SELECT COUNT(*) FROM courses";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
