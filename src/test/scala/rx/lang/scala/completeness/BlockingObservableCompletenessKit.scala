/**
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.lang.scala.completeness

import scala.reflect.runtime.universe.typeOf

class BlockingObservableCompletenessKit extends CompletenessKit {
  override def rxJavaType = typeOf[rx.observables.BlockingObservable[_]]

  override def rxScalaType = typeOf[rx.lang.scala.observables.BlockingObservable[_]]

  override protected def correspondenceChanges = Map(
    "first(Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.head`]",
    "firstOrDefault(T)" -> "headOrElse(=> U)",
    "firstOrDefault(T, Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.headOrElse(=> U)`]",
    "forEach(Action1[_ >: T])" -> "foreach(T => Unit)",
    "from(Observable[_ <: T])" -> "[use `Observable.toBlocking`]",
    "last(Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.last`]",
    "lastOrDefault(T)" -> "lastOrElse(=> U)",
    "lastOrDefault(T, Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.lastOrElse(=> U)`]",
    "mostRecent(T)" -> "mostRecent(U)",
    "single(Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.single`]",
    "singleOrDefault(T)" -> "singleOrElse(=> U)",
    "singleOrDefault(T, Func1[_ >: T, Boolean])" -> "[use `Observable.filter(p).toBlocking.singleOrElse(=> U)`]",
    "getIterator()" -> "[use `toIterable.toIterator`]"
  )
}
