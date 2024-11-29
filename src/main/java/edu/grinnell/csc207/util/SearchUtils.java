package edu.grinnell.csc207.util;

import java.util.function.Predicate;

/**
 * Assorted utilities for searching structures.
 *
 * @author Sam Schmidt
 * @author Jenifer Silva
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchUtils {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *               A sorted array of integers
   * @param val
   *               An integer we're searching for
   * @return
   *         index, an index of val (if one exists)
   * @throws Exception
   *                   If there is no i s.t. values[i] == val
   * @pre
   *      values is sorted in increasing order. That is, values[i] <
   *      values[i+1] for all reasonable i.
   * @post
   *       values[index] == val
   */
  static int iterativeBinarySearch(int[] vals, int i) throws Exception {
    int lb = 0;
    int ub = vals.length;

    while (lb < ub) {
      int mid = lb + (ub - lb) / 2;

      if (vals[mid] == i) {
        return mid;
      } else if (vals[mid] > i) {
        ub = mid;
      } else {
        lb = mid + 1;
      } // endif
    } // while
    throw new Exception("Value not found");
  } // iterativeBinarySearch

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *               A sorted array of integers
   * @param val
   *               An integer we're searching for
   * @return
   *         index, an index of val (if one exists)
   * @throws Exception
   *                   If there is no i s.t. values[i] == val
   * @pre
   *      values is sorted in increasing order. That is, values[i] <
   *      values[i+1] for all reasonable i.
   * @post
   *       values[index] == val
   */
  static int recursiveBinarySearch(int[] vals, int i) throws Exception {
    int lb = 0;
    int ub = vals.length - 1;
    return rbsHelper(vals, lb, ub, i);
  } // recursiveBinarySearch

  /**
   * Search for val in a subarray of values, return the index of an
   * instance of val.
   *
   * @param values
   *               A sorted array of integers
   * @param lb
   *               The lower bound of the area of interest (inclusive)
   * @param ub
   *               The upper bound of the area of interest (exclusive)
   * @param val
   *               An integer we're searching for
   * @return
   *         index, an index of val (if one exists)
   * @throws Exception
   *                   If there is no i between lb and ub s.t. values[i] == val
   * @pre
   *      values is sorted in increasing order. That is, values[i] <
   *      values[i+1] for all reasonable i.
   * @post
   *       values[index] == val
   */
  static int rbsHelper(int[] vals, int lb, int ub, int i) throws Exception {
    int mid = lb + (ub - lb) / 2;

    if (lb > ub) {
      throw new Exception("Value not found");
    } // endif

    if (vals[mid] == i) {
      return mid;
    } else if (vals[mid] > i) {
      if (ub == lb) {
        throw new Exception("Value not found");
      } else {
        return rbsHelper(vals, lb, mid, i);
      } // endif
    } else {
      if (mid + 1 >= vals.length) {
        throw new Exception("Value not found");
      } else {
        return rbsHelper(vals, mid + 1, ub, i);
      } // endif
    } // endif
  } // rbsHelper

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Search values for the first value for which pred holds.
   *
   * @param <T>
   *               The type of values we're examining
   * @param values
   *               The iterable we're searching
   * @param pred
   *               The predicate used to determine whether or not the value is
   *               acceptable
   * 
   * @return the first mathcing element.
   *
   * @throws Exception
   *                   If no matching value is found.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) throws Exception {
    for (T i : values) {
      if (pred.test(i)) {
        return i;
      }
    }
    throw new Exception("No value found");
  }

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *               A sorted array of integers
   * @param val
   *               An integer we're searching for
   * @return
   *         index, an index of val (if one exists)
   * @throws Exception
   *                   If there is no i s.t. values[i] == val
   * @pre
   *      values is sorted in increasing order. That is, values[i] <
   *      values[i+1] for all reasonable i.
   * @post
   *       values[index] == val
   */
  public static int binarySearch(int[] vals, int i) throws Exception {
    return iterativeBinarySearch(vals, i);
    // return recursiveBinarySearch(vals, i);
  } // binarySearch

} // class SearchUtils
